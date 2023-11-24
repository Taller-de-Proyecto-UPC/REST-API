package com.tp.neuralscan.person.controller;

import com.tp.neuralscan.person.dto.*;
import com.tp.neuralscan.person.mapping.PersonMapper;
import com.tp.neuralscan.person.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Person", description = "Person API")
@RestController
@RequestMapping("/api/v1/person")
@CrossOrigin
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonMapper personMapper;

    @Operation(summary = "Get all Persons", description = "Get all Persons")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all Persons"),
            @ApiResponse(responseCode = "404", description = "Persons not found")})
    @GetMapping
    public List<PersonResource> getAllPersons() {
        return personMapper.toResource(personService.getAllPersons());
    }

    @Operation(summary = "Create Person", description = "Create Person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created Person"),
            @ApiResponse(responseCode = "404", description = "Person not created")})
    @PostMapping("/create")
    public PersonResource createPerson(@RequestBody CreatePersonResource createPersonResource) {
        return personMapper.toResource(personService.createPerson(personMapper.toEntity(createPersonResource)));
    }

    @Operation(summary = "Update Person", description = "Update Person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated Person"),
            @ApiResponse(responseCode = "404", description = "Person not updated")})
    @PutMapping("/{id}")
    public PersonResource updatePerson(@PathVariable(name = "id") Long id, @RequestBody UpdatePersonResource updatePersonResource) {
        return personMapper.toResource(personService.updatePerson(id,
                personMapper.toEntity(updatePersonResource)));
    }

}
