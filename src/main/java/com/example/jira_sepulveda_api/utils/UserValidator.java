package com.example.jira_sepulveda_api.utils;

import com.example.jira_sepulveda_api.exception.InvalidUserException;
import com.example.jira_sepulveda_api.model.UserModel;
import org.springframework.util.StringUtils;

public class UserValidator {

    private UserValidator() {
        // Evita que se instancie esta clase
    }

    public static void validate(UserModel user) {
        if (user == null) {
            throw new InvalidUserException("User cannot be null");
        }
        if (!StringUtils.hasText(user.getName())) {
           throw new InvalidUserException("Name is required");
        }
        if (!StringUtils.hasText(user.getEmail())) {
            throw new InvalidUserException("Email is required");
        }
        if (!user.getEmail().contains("@")) {
            throw new InvalidUserException("Email must contain '@'");
        }
        if (!StringUtils.hasText(user.getDocumentType())) {
            throw new InvalidUserException("Document type is required");
        }
        if (user.getDocumentNumber() == null || user.getDocumentNumber() <= 0) {
            throw new InvalidUserException("Document number must be positive");
        }
        if (!StringUtils.hasText(user.getRole())) {
            throw new InvalidUserException("Role is required");
        }
    }
}