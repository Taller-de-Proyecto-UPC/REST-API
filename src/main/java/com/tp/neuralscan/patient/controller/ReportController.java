package com.tp.neuralscan.patient.controller;

import com.tp.neuralscan.patient.dto.CreateReportResource;
import com.tp.neuralscan.patient.dto.ReportResource;
import com.tp.neuralscan.patient.dto.UpdateReportResource;
import com.tp.neuralscan.patient.mapping.ImageMapper;
import com.tp.neuralscan.patient.mapping.ReportMapper;
import com.tp.neuralscan.patient.model.ImageEntity;
import com.tp.neuralscan.patient.model.ReportEntity;
import com.tp.neuralscan.patient.service.ReportService;
import com.tp.neuralscan.person.model.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Tag(name = "Report", description = "Report API")
@RestController
@RequestMapping("/api/v1/report")
@CrossOrigin
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private ReportMapper reportMapper;

    @Autowired
    private ImageMapper imageMapper;

    public static final String DIRECTORY = "C:/Users/UsuarioTK/Desktop/NeuralScan Application/webapp/src/assets/upload";
    @Operation(summary = "Get all Reports", description = "Get all Reports")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all Reports"),
            @ApiResponse(responseCode = "404", description = "Reports not found")})
    @GetMapping
    public List<ReportResource> getAllReports() {
        return reportMapper.toResource(reportService.getAllReports());
    }


    @Operation(summary = "Create Report", description = "Create Report")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created Report"),
            @ApiResponse(responseCode = "404", description = "Report not created")})
    @PostMapping("doctor/{doctorId}/patient/{patientId}/create")
    public ReportResource createReport(@RequestBody CreateReportResource createReportResource, @PathVariable("doctorId") Long doctorId, @PathVariable("patientId") Long patientId) {
        ImageEntity imageEntity = imageMapper.toEntity(createReportResource.getImage());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(new Date());
        imageEntity.setAdded(currentDate);
        imageEntity.setPath(DIRECTORY);

        return reportMapper.toResource(reportService.createReport(reportMapper.toEntity(createReportResource), doctorId, patientId, imageEntity));
    }

    @Operation(summary = "Update Report", description = "Update Report")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated Report"),
            @ApiResponse(responseCode = "404", description = "Report not updated")})
    @PutMapping("/{id}")
    public ReportResource updateReport(@PathVariable(name = "id") Long id, @RequestBody UpdateReportResource updateReportResource) {
        return reportMapper.toResource(reportService.updateReport(id,
                reportMapper.toEntity(updateReportResource)));
    }

    @Operation(summary = "Get all reports by patientId", description = "Get all reports by patientId")
    @GetMapping("patient/{patientId}")
    public List<ReportResource> getAllReportsByPatientId(@PathVariable Long patientId) {
        return reportMapper.toResource(reportService.getAllReportsByPatientId(patientId));
    }

    @Operation(summary = "Get all reports by doctorId", description = "Get all reports by doctorId")
    @GetMapping("doctor/{doctorId}")
    public List<ReportResource> getAllReportsByDoctorId(@PathVariable Long doctorId) {
        return reportMapper.toResource(reportService.getAllReportsByDoctorId(doctorId));
    }

    @PostMapping ("{reportId}/upload")
    public ResponseEntity <List<String>> uploadFiles(@PathVariable Long reportId, @RequestParam("files")List<MultipartFile> multipartFiles) throws IOException{
        ReportEntity report = reportService.getReportById(reportId);
        ImageEntity image = report.getImageEntity();

        List<String> filenames = new ArrayList<>();
        for (MultipartFile file : multipartFiles){
            String filename = StringUtils.cleanPath(reportId.toString()+".jpg");
            Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
            copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
            filenames.add(filename);
            report.getImageEntity().setPath(image.getPath()+"/"+filename);
        }
        reportService.updateReport(reportId, report);

        return ResponseEntity.ok().body(filenames);
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("filename") String filename) throws IOException {
        Path filepath = get(DIRECTORY).toAbsolutePath().normalize().resolve(filename+".jpg");

        if(!Files.exists(filepath)) {
            throw new FileNotFoundException(filename + " was not found");
        }

        Resource resource = new UrlResource(filepath.toUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("File-Name", filename);
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;File-Name="+ resource.getFilename());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filepath))).headers(httpHeaders).body(resource);
    }

}
