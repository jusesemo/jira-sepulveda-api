package com.example.jira_sepulveda_api.controller;

import com.example.jira_sepulveda_api.exception.InvalidUserException;
import com.example.jira_sepulveda_api.model.UserModel;
import com.example.jira_sepulveda_api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // Indicates this class handles REST requests
@RequestMapping("/api/users") // Base URL for user-related endpoints
public class UserController {

    private final UserService userService;

    // Dependency injection: Spring creates UserService and passes it here
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint to create a user (POST)
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserModel user) {
        try {
            // Validate the user with the service (business rules)
            userService.validateUser(user);

            // If validations pass, return 200 OK with the user
            return ResponseEntity.ok(user);
        } catch (InvalidUserException e) {
            // Validation error -> return 400 Bad Request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            // Any unexpected error -> 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error"));
        }
    }
}