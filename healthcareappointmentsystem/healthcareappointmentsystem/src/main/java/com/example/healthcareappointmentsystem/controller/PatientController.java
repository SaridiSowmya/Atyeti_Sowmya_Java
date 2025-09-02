package com.example.healthcareappointmentsystem.controller;
import com.example.healthcareappointmentsystem.dto.PatientDTO;
import com.example.healthcareappointmentsystem.model.Patient;
import com.example.healthcareappointmentsystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> register(@RequestBody PatientDTO dto) {
        return ResponseEntity.ok(patientService.registerPatient(dto));
    }

    @GetMapping
    public List<Patient> getAll() {
        return patientService.getAllPatients();
    }
}
