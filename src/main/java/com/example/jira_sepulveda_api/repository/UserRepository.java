package com.example.jira_sepulveda_api.repository;

import com.example.jira_sepulveda_api.model.UserModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository // Indicates to Spring that this class handles the data layer
public class UserRepository {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String FILE_PATH = "./data/users.json";

    /**
     * method findAll() Method that returns all users saved in the JSON file.
     */
    public List<UserModel> findAll() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return new ArrayList<>(); // si no existe, retorna lista vacía
            }
            return objectMapper.readValue(file, new TypeReference<List<UserModel>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Method that saves a new user to the JSON file.
     */
    public synchronized void save(UserModel user) {
        try {
            File file = new File(FILE_PATH);
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            List<UserModel> users = findAll(); // leer los existentes
            users.add(user); // agregar el nuevo
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, users); // guardar
        } catch (IOException e) {
        throw new RuntimeException("Error al guardar el usuario", e);
    }
        }
           // Read user by id
           
    public UserModel findById(Integer id) {
        List<UserModel> users = findAll();
        for (UserModel user : users) {
            if (user.getId() != null && user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
