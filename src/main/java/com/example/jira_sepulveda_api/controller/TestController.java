package com.example.jira_sepulveda_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/test/saludo")
    public String saludo() {
        return "Hola desde el endpoint local!";
    }
}