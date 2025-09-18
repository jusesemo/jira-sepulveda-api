package com.example.jira_sepulveda_api.controller;

import com.example.jira_sepulveda_api.exception.InvalidUserException;
import com.example.jira_sepulveda_api.model.User;
import com.example.jira_sepulveda_api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // Indica que esta clase maneja peticiones REST
@RequestMapping("/api/users") // URL base para todo lo relacionado con usuarios
public class UserController {

    private final UserService userService;

    // Inyección de dependencias: Spring crea UserService y lo pasa aquí
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint para crear usuario (POST)
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            // Validamos el usuario con el servicio
            userService.validateUser(user);

            // Si pasa las validaciones, devolvemos 200 OK con el usuario
            return ResponseEntity.ok(user);
        } catch (InvalidUserException e) {
            // Si hay error de validación, devolvemos 400 Bad Request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            // Cualquier otro error inesperado → 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error"));
        }
    }
}