package com.example.jira_sepulveda_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class user {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nombre")
    private String name;

    @JsonProperty("correo")
    private String email;

    @JsonProperty("tipo")
    private String documentType;

    @JsonProperty("numero")
    private Integer documentNumber;

    @JsonProperty("rol")
    private String role;
}
