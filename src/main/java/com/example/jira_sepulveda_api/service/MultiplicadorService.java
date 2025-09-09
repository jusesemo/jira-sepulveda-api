package com.example.jira_sepulveda_api.service;

import org.springframework.stereotype.Service;

@Service
public class MultiplicadorService {

    public int multiplicarPorQuince(int numero) {
        return numero * 15;
    }
}