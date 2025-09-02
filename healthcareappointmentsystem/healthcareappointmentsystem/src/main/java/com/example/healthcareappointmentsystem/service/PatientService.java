package com.example.healthcareappointmentsystem.service;

import com.example.healthcareappointmentsystem.dto.PatientDTO;
import com.example.healthcareappointmentsystem.model.Patient;
import com.example.healthcareappointmentsystem.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepo;

    public Patient registerPatient(PatientDTO dto) {
        Patient p = new Patient();
        p.setName(dto.getName());
        p.setAge(dto.getAge());
        p.setGender(dto.getGender());
        p.setContact(dto.getContact());
        return patientRepo.save(p);
    }

    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    public void deletePatientById(int id) {
        if (!patientRepo.existsById(id)) {
            throw new RuntimeException("Patient with ID " + id + " not found");
        }
        patientRepo.deleteById(id);
    }
}

