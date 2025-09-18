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
