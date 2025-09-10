package com.example.smartcartecommerce.dto;


import com.example.smartcartecommerce.model.Role;
import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String password;
    private String name;
    private String email;
    private Role role;
}

