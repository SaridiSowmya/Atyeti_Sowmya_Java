package com.example.healthcareappointmentsystem.service;
import com.example.healthcareappointmentsystem.dto.DoctorDTO;
import com.example.healthcareappointmentsystem.model.Doctor;
import com.example.healthcareappointmentsystem.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepo;

    public Doctor registerDoctor(DoctorDTO dto) {
        Doctor d = new Doctor();
        d.setName(dto.getName());
        d.setSpecialization(dto.getSpecialization());
        d.setAvailableDays(dto.getAvailableDays());
        return doctorRepo.save(d);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    public void deleteDoctorById(int id) {
        if (!doctorRepo.existsById(id)) {
            throw new RuntimeException("Doctor with ID " + id + " not found");
        }
        doctorRepo.deleteById(id);
    }
}

