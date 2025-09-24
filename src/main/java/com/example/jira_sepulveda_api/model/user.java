package com.example.jira_sepulveda_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// utilizar solo 1, entre NoArgsConstructor y AllArgsConstructor, depende lo necesario
@NoArgsConstructor 
@AllArgsConstructor
public class User { 

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("documentType")
    private String documentType;

    @JsonProperty("documentNumber")
    private Integer documentNumber;

    @JsonProperty("role")
    private String role;
}

