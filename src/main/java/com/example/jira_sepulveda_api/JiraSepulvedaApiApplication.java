package com.example.jira_sepulveda_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Indica que es una aplicacion de Spring Boot
public class JiraSepulvedaApiApplication {

	public static void main(String[] args) {
		// SpringApplication.run starts the embedded server (default port 8080)
		SpringApplication.run(JiraSepulvedaApiApplication.class, args);
		System.out.println("Spring Boot server is running");

	}
}



	//   // 🚀 PRUEBA TEMPORAL DEL REPOSITORY
	//   try {
	// 	com.example.jira_sepulveda_api.repository.UserRepository repo = new com.example.jira_sepulveda_api.repository.UserRepository();

	// 	com.example.jira_sepulveda_api.model.UserModel user = new com.example.jira_sepulveda_api.model.UserModel();
	// 	user.setId(1);
	// 	user.setName("Sebastian");
	// 	user.setEmail("seb@mail.com");
	// 	user.setDocumentType("CC");
	// 	user.setDocumentNumber(123456);
	// 	user.setRole("Admin");

	// 	repo.save(user);
	// 	System.out.println("Usuario guardado exitosamente ✅");
	// 	System.out.println("Usuarios actuales: " + repo.findAll());

	// } catch (Exception e) {
	// 	e.printStackTrace();