package com.example.jira_sepulveda_api.service;

import com.example.jira_sepulveda_api.model.UserModel;
import com.example.jira_sepulveda_api.repository.UserRepository;
import com.example.jira_sepulveda_api.utils.UserValidator;
import com.example.jira_sepulveda_api.exception.InvalidUserException;
import org.springframework.stereotype.Service;
// import java.util.List;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel createUser(UserModel user) {
        if (user == null || user.getId() == null) {
            throw new InvalidUserException("Id is required");
        }
        if (userRepository.findById(user.getId()) != null) {
            throw new InvalidUserException("User with this id already exists");
        }
        UserValidator.validate(user);
        userRepository.save(user);
        return user;
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(Integer id) {
        return userRepository.findById(id);
    }
}