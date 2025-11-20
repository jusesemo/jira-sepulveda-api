package com.example.jira_sepulveda_api.controller;

import com.example.jira_sepulveda_api.exception.InvalidUserException;
import com.example.jira_sepulveda_api.model.UserModel;
import com.example.jira_sepulveda_api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // Indicates this class handles REST requests
@RequestMapping("/api/users") // Base URL for user-related endpoints - path o ruta 
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
            // Validar y persistir
            UserModel created = userService.createUser(user);
            System.out.println("Usuario creado: " + created);
            return ResponseEntity.ok(created);
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

    // Endpoint to get all users (GET)
    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        try {
            List<UserModel> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error"));
        }
    }

    // Endpoint to get a user by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        try {
            UserModel user = userService.getUserById(id);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("error", "User not found"));
            }
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error"));
        }
    }
}