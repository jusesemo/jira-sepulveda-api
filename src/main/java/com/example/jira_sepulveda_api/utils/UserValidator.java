package com.example.jira_sepulveda_api.service;

import com.example.jira_sepulveda_api.model.UserModel;
import com.example.jira_sepulveda_api.repository.UserRepository;
import com.example.jira_sepulveda_api.utils.UserValidator;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel createUser(UserModel user) {
        UserValidator.validate(user); // 👉 ahora se usa la clase utilitaria
        userRepository.save(user);
        return user;
    }
}