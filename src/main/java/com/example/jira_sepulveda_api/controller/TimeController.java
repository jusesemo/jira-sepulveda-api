package com.example.jira_sepulveda_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * Controlador REST responsable SOLO de exponer la hora del servidor
 * y un ping opcional. (SRP)
 */
@RestController
@RequestMapping("/api")
public class TimeController {

    // GET /api/time → retorna hora del servidor en ISO-8601
    @GetMapping("/time")
    public ResponseEntity<Map<String, String>> getServerTime() {
        String now = ZonedDateTime.now().format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
        return ResponseEntity.ok(Map.of("serverTime", now));
    }

    // (Opcional) GET /api/ping → verifica que el backend está activo
    @GetMapping("/ping")
    public ResponseEntity<Map<String, String>> ping() {
        return ResponseEntity.ok(Map.of("status", "ok"));
    }
}
