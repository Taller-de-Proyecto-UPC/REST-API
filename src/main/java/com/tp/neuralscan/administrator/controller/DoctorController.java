package com.tp.neuralscan.administrator.controller;

import com.tp.neuralscan.administrator.dto.CreateDoctorResource;
import com.tp.neuralscan.administrator.dto.DoctorResource;
import com.tp.neuralscan.administrator.dto.UpdateDoctorResource;
import com.tp.neuralscan.administrator.mapping.DoctorMapper;
import com.tp.neuralscan.administrator.service.DoctorService;
import com.tp.neuralscan.person.dto.LoginPredictionResource;
import com.tp.neuralscan.person.dto.UserResource;
import com.tp.neuralscan.person.mapping.UserMapper;
import com.tp.neuralscan.person.model.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Doctor", description = "Doctor API")
@RestController
@RequestMapping("/api/v1/doctor")
@CrossOrigin
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private UserMapper userMapper;

    @Operation(summary = "Get all doctors", description = "Get all Doctors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all Doctors"),
            @ApiResponse(responseCode = "404", description = "Doctors not found")})
    @GetMapping
    public List<DoctorResource> getAllDoctors() {
        return doctorMapper.toResource(doctorService.getAllDoctors());
    }

    @Operation(summary = "Create Doctor", description = "Create Doctor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created Doctor"),
            @ApiResponse(responseCode = "404", description = "Doctor not created")})
    @PostMapping("/create")
    public DoctorResource createDoctor(@RequestBody CreateDoctorResource createDoctorResource) {
        UserEntity userEntity = userMapper.toEntity(createDoctorResource.getUser());

        return doctorMapper.toResource(doctorService.createDoctor(doctorMapper.toEntity(createDoctorResource), userEntity));
    }

    @Operation(summary = "Get Doctor by username", description = "Get Doctor by username")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Doctor"),
            @ApiResponse(responseCode = "404", description = "Doctor not found")})
    @PostMapping("/username/{username}")
    public DoctorResource getDoctorByUsername(@PathVariable(name = "username") String username) {
        return doctorMapper.toResource(doctorService.findByUsername(username));
    }

    @Operation(summary = "Update Doctor", description = "Update Doctor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated Doctor"),
            @ApiResponse(responseCode = "404", description = "Doctor not updated")})
    @PutMapping("/{id}")
    public DoctorResource updateDoctor(@PathVariable(name = "id") Long id, @RequestBody UpdateDoctorResource updateDoctorResource) {
        return doctorMapper.toResource(doctorService.updateDoctor(id,
                doctorMapper.toEntity(updateDoctorResource)));
    }

    @Operation(summary = "Delete doctor", description = "Delete doctor")
    @DeleteMapping("{id}")
    public Optional<ResponseEntity<Object>> deleteDoctor(@PathVariable Long id) {
        return doctorService.deleteDoctor(id);
    }

}
