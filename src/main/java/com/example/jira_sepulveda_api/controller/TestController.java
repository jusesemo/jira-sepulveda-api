package com.example.jira_sepulveda_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Este @RestController indica que es un controlador y define las rutas
@RestController
@RequestMapping("/api/Supersepol")
public class TestController {

    @GetMapping("/saludo")
    public String saludo() {
        return "Enaaaa hpta!";
    }
    @GetMapping("/despedida")
    public String despedida() {
        return "Vemos fap";
    

    }
}