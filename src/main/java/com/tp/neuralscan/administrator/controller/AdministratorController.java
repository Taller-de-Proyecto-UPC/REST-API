package com.tp.neuralscan.administrator.controller;

import com.tp.neuralscan.administrator.dto.CreateAdministratorResource;
import com.tp.neuralscan.administrator.dto.AdministratorResource;
import com.tp.neuralscan.administrator.dto.LoginPredictionResource;
import com.tp.neuralscan.administrator.dto.UpdateAdministratorResource;
import com.tp.neuralscan.administrator.mapping.AdministratorMapper;
import com.tp.neuralscan.administrator.service.AdministratorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Administrator", description = "Administrator API")
@RestController
@RequestMapping("/api/v1/administrator")
@CrossOrigin
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private AdministratorMapper administratorMapper;

    @Operation(summary = "Get all Administrators", description = "Get all Administrators")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all Administrators"),
            @ApiResponse(responseCode = "404", description = "Administrators not found")})
    @GetMapping
    public List<AdministratorResource> getAllAdministrators() {
        return administratorMapper.toResource(administratorService.getAllAdministrators());
    }

    @Operation(summary = "Get Administrators by email", description = "Get Administrators by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Administrator"),
            @ApiResponse(responseCode = "404", description = "Administrator not found")})
    @PostMapping("/login")
    public AdministratorResource loginAdministrator(@RequestBody LoginPredictionResource loginPredictionResource) {
        return administratorMapper.toResource(administratorService.loginAdministrator(loginPredictionResource.getEmail(),
                loginPredictionResource.getPassword()));
    }

    @Operation(summary = "Create Administrator", description = "Create Administrator")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created Administrator"),
            @ApiResponse(responseCode = "404", description = "Administrator not created")})
    @PostMapping("/create")
    public AdministratorResource createAdministrator(@RequestBody CreateAdministratorResource createAdministratorResource) {
        return administratorMapper.toResource(administratorService.createAdministrator(administratorMapper.toEntity(createAdministratorResource)));
    }

    @Operation(summary = "Update Administrator", description = "Update Administrator")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated Administrator"),
            @ApiResponse(responseCode = "404", description = "Administrator not updated")})
    @PutMapping("/{id}")
    public AdministratorResource updateAdministrator(@PathVariable(name = "id") Long id, @RequestBody UpdateAdministratorResource updateAdministratorResource) {
        return administratorMapper.toResource(administratorService.updateAdministrator(id,
                administratorMapper.toEntity(updateAdministratorResource)));
    }

}
