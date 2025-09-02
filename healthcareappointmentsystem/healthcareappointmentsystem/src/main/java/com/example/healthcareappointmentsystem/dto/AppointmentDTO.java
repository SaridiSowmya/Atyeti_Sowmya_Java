package com.example.healthcareappointmentsystem.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    private int patientId;
    private int doctorId;
    private String appointmentTime;
}

