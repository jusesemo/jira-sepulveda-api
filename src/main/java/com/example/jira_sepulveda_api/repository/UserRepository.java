package com.example.jira_sepulveda_api.repository;

import com.example.jira_sepulveda_api.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository // Indica a Spring que esta clase maneja la capa de datos
public class UserRepository {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String FILE_PATH = "./data/users.json";

    /**
     * Método que retorna todos los usuarios guardados en el archivo JSON.
     */
    public List<User> findAll() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return new ArrayList<>(); // si no existe, retorna lista vacía
            }
            return objectMapper.readValue(file, new TypeReference<List<User>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Método que guarda un nuevo usuario en el archivo JSON.
     */
    public synchronized void save(User user) {
        try {
            List<User> users = findAll(); // leer los existentes
            users.add(user); // agregar el nuevo
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), users); // guardar
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}