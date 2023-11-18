package com.tp.neuralscan.patient.controller;

import com.tp.neuralscan.patient.dto.PatientResource;
import com.tp.neuralscan.patient.dto.CreatePatientResource;
import com.tp.neuralscan.patient.dto.UpdatePatientResource;
import com.tp.neuralscan.patient.mapping.PatientMapper;
import com.tp.neuralscan.patient.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Patient", description = "Patient API")
@RestController
@RequestMapping("/api/v1/patient")
@CrossOrigin
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientMapper patientMapper;

    @Operation(summary = "Get all Patients", description = "Get all Patients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all Patients"),
            @ApiResponse(responseCode = "404", description = "Patients not found")})
    @GetMapping
    public List<PatientResource> getAllPatients() {
        return patientMapper.toResource(patientService.getAllPatients());
    }

    @Operation(summary = "Create Patient", description = "Create Patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created Patient"),
            @ApiResponse(responseCode = "404", description = "Patient not created")})
    @PostMapping("{doctorId}/create")
    public PatientResource createPatient(@RequestBody CreatePatientResource createPatientResource, @PathVariable("doctorId") Long doctorId) {
        return patientMapper.toResource(patientService.createPatient(patientMapper.toEntity(createPatientResource), doctorId));
    }

    @Operation(summary = "Update Patient", description = "Update Patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated Patient"),
            @ApiResponse(responseCode = "404", description = "Patient not updated")})
    @PutMapping("/{id}")
    public PatientResource updatePatient(@PathVariable(name = "id") Long id, @RequestBody UpdatePatientResource updatePatientResource) {
        return patientMapper.toResource(patientService.updatePatient(id,
                patientMapper.toEntity(updatePatientResource)));
    }

    @Operation(summary = "Delete patient", description = "Delete patient")
    @DeleteMapping("{id}")
    public Optional<ResponseEntity<Object>> deleteDoctor(@PathVariable Long id) {
        return patientService.deletePatient(id);
    }

}
