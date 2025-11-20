package com.example.jira_sepulveda_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor 
public class UserModel {



    private Integer id;


    private String name;

   
    private String email;

   
    private String documentType;
    
  
    private Integer documentNumber;


    private String role;
}

