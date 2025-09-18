package com.example.jira_sepulveda_api.service;

import com.example.jira_sepulveda_api.exception.InvalidUserException;
import com.example.jira_sepulveda_api.model.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService {

    public void validateUser(User user) {
        if (user == null) {
            throw new InvalidUserException("El usuario no puede ser nulo");
        }
        if (!StringUtils.hasText(user.getName())) {
            throw new InvalidUserException("El nombre es obligatorio");
        }
        if (!StringUtils.hasText(user.getEmail())) {
            throw new InvalidUserException("El correo es obligatorio");
        }
        if (!StringUtils.hasText(user.getDocumentType())) {
            throw new InvalidUserException("El tipo de documento es obligatorio");
        }
        if (user.getDocumentNumber() == null || user.getDocumentNumber() <= 0) {
            throw new InvalidUserException("El número de documento debe ser positivo");
        }
        if (!StringUtils.hasText(user.getRole())) {
            throw new InvalidUserException("El rol es obligatorio");
        }
    }
}