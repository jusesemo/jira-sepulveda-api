package com.example.jira_sepulveda_api.controller;

import com.example.jira_sepulveda_api.service.MultiplicadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiplicadorController {

    private final MultiplicadorService multiplicadorService;

    @Autowired
    public MultiplicadorController(MultiplicadorService multiplicadorService) {
        this.multiplicadorService = multiplicadorService;
    }

    @GetMapping("/api/multiplicar")
    public int multiplicar(@RequestParam Integer numero) {
        return multiplicadorService.multiplicarPorQuince(numero);
    }
}