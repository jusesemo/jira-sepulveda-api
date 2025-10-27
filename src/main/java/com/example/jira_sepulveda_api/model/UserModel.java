package com.example.jira_sepulveda_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor 
public class UserModel {


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

