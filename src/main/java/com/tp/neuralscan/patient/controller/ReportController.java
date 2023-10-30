package com.tp.neuralscan.patient.controller;

import com.tp.neuralscan.patient.dto.CreateReportResource;
import com.tp.neuralscan.patient.dto.ReportResource;
import com.tp.neuralscan.patient.dto.UpdateReportResource;
import com.tp.neuralscan.patient.mapping.ReportMapper;
import com.tp.neuralscan.patient.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Report", description = "Report API")
@RestController
@RequestMapping("/api/v1/report")
@CrossOrigin
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private ReportMapper reportMapper;

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
    @PostMapping("/create")
    public ReportResource createReport(@RequestBody CreateReportResource createReportResource) {
        return reportMapper.toResource(reportService.createReport(reportMapper.toEntity(createReportResource)));
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

}
