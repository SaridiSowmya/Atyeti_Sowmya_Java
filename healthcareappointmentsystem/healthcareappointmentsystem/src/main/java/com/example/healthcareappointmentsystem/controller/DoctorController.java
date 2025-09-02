package com.example.healthcareappointmentsystem.controller;
import com.example.healthcareappointmentsystem.dto.DoctorDTO;
import com.example.healthcareappointmentsystem.model.Doctor;
import com.example.healthcareappointmentsystem.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Doctor> register(@RequestBody DoctorDTO dto) {
        return ResponseEntity.ok(doctorService.registerDoctor(dto));
    }

    @GetMapping
    public List<Doctor> getAll() {
        return doctorService.getAllDoctors();
    }
}

