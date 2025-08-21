package com.example.demo.controller;

import com.example.demo.Entity.User;
import com.example.demo.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Create a new user", description = "This endpoint allows you to create a new user.")
    @ApiResponse(responseCode = "200", description = "User created successfully")
    @PostMapping
    public String createUser(@Parameter(description = "User details") @RequestBody User user) {
        userService.createUser(user);
        return "User created!";
    }

    @Operation(summary = "Get the user by user Id", description = "This endpoint allows you to acess the user details.")
    @ApiResponse(description = "API has been successfully called")
    @GetMapping("/{userId}")
    public User getUser(@Parameter(description = "User Id")@PathVariable String userId) {
        return userService.readUser(userId);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User deleted!";
    }
}
