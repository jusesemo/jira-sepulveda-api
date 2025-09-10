package com.example.jira_sepulveda_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Indica que es una aplicacion de Spring Boot
public class JiraSepulvedaApiApplication {

	public static void main(String[] args) {
		// Springaplication.run hace que se escuche un puerto ( Por defecto el 8080 ) //
		SpringApplication.run(JiraSepulvedaApiApplication.class, args);
		System.out.println(" EL servidor sprint boot esta corriendo");
	}

}
