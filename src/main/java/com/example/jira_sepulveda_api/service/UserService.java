package com.example.jira_sepulveda_api.service;

import com.example.jira_sepulveda_api.exception.InvalidUserException;
import com.example.jira_sepulveda_api.model.User;
import org.springframework.stereotype.Service;

@Service // Esto le dice a Spring que esta clase es un servicio
public class UserService {

    // Método principal: validar un usuario completo
    public void validateUser(User user) {
        if (user == null) {
            throw new InvalidUserException("User cannot be null");
        }

        // Aquí aplicamos SRP: cada validación está en un método aparte
        validateId(user.getId());
        validateName(user.getName());
        validateEmail(user.getEmail());
    }

    // Validación del ID
    private void validateId(Integer id) {
        if (id == null || id <= 0) {
            throw new InvalidUserException("Invalid id: must be positive");
        }
    }

    // Validación del nombre
    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidUserException("Name cannot be empty");
        }
    }

    // Validación del correo
    private void validateEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new InvalidUserException("Invalid email: must contain '@'");
        }
    }
}