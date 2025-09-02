package com.example.healthcareappointmentsystem.controller;
import com.example.healthcareappointmentsystem.dto.DoctorDTO;
import com.example.healthcareappointmentsystem.model.Doctor;
import com.example.healthcareappointmentsystem.model.Patient;
import com.example.healthcareappointmentsystem.model.Appointment;
import com.example.healthcareappointmentsystem.service.DoctorService;
import com.example.healthcareappointmentsystem.service.PatientService;
import com.example.healthcareappointmentsystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;


    @PostMapping("/doctor")
    public Doctor saveDoctor(@RequestBody DoctorDTO dto) {
        return doctorService.registerDoctor(dto);
    }

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @DeleteMapping("/doctor/{id}")
    public String deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctorById(id);
        return "Doctor deleted with id: " + id;
    }

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @DeleteMapping("/patient/{id}")
    public String deletePatient(@PathVariable int id) {
        patientService.deletePatientById(id);
        return "Patient deleted with id: " + id;
    }


    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @DeleteMapping("/appointment/{id}")
    public String cancelAppointment(@PathVariable int id) {
        appointmentService.cancelAppointment(id);
        return "Appointment cancelled with id: " + id;
    }
}

