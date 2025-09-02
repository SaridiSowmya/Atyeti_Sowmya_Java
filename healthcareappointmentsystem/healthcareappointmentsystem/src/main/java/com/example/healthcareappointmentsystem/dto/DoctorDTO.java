package com.example.healthcareappointmentsystem.dto;

import com.example.healthcareappointmentsystem.model.Specialization;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private String name;
    private Specialization specialization;
    private String availableDays;
}

