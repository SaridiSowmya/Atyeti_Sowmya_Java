package com.example.healthcareappointmentsystem.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private String name;
    private int age;
    private String gender;
    private String contact;
}

