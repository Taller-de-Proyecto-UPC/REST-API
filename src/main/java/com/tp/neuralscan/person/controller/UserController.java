package com.tp.neuralscan.person.controller;


import com.tp.neuralscan.person.dto.CreateUserResource;
import com.tp.neuralscan.person.dto.LoginPredictionResource;
import com.tp.neuralscan.person.dto.UpdateUserResource;
import com.tp.neuralscan.person.dto.UserResource;
import com.tp.neuralscan.person.mapping.UserMapper;
import com.tp.neuralscan.person.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "User", description = "User API")
@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Operation(summary = "Get all users", description = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all users"),
            @ApiResponse(responseCode = "404", description = "users not found")})
    @GetMapping
    public List<UserResource> getAllUsers() {
        return userMapper.toResource(userService.getAllUsers());
    }

    @Operation(summary = "Get users by email", description = "Get users by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the User"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @PostMapping("/login")
    public UserResource loginDoctor(@RequestBody LoginPredictionResource loginPredictionResource) {
        return userMapper.toResource(userService.login(loginPredictionResource.getEmail(),
                loginPredictionResource.getPassword()));
    }

    @Operation(summary = "Create User", description = "Create User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created User"),
            @ApiResponse(responseCode = "404", description = "User not created")})
    @PostMapping("/create")
    public UserResource createUser(@RequestBody CreateUserResource CreateUserResource) {
        return userMapper.toResource(userService.createUser(userMapper.toEntity(CreateUserResource)));
    }

    @Operation(summary = "Update User", description = "Update User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated User"),
            @ApiResponse(responseCode = "404", description = "User not updated")})
    @PutMapping("/{id}")
    public UserResource updateUser(@PathVariable(name = "id") Long id, @RequestBody UpdateUserResource updateUserResource) {
        return userMapper.toResource(userService.updateUser(id,
                userMapper.toEntity(updateUserResource)));
    }

    @Operation(summary = "Delete User", description = "Delete User")
    @DeleteMapping("{id}")
    public Optional<ResponseEntity<Object>> deleteDoctor(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

}
