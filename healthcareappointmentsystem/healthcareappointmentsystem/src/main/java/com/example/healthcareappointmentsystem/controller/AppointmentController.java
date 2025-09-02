package com.example.healthcareappointmentsystem.controller;
import com.example.healthcareappointmentsystem.dto.AppointmentDTO;
import com.example.healthcareappointmentsystem.model.Appointment;
import com.example.healthcareappointmentsystem.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity<Appointment> book(@RequestBody AppointmentDTO dto) {
        return ResponseEntity.ok(appointmentService.bookAppointment(dto));
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<String> cancel(@PathVariable int id) {
        appointmentService.cancelAppointment(id);
        return ResponseEntity.ok("Appointment Cancelled Successfully");
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getDoctorAppointments(@PathVariable int doctorId) {
        return appointmentService.getAppointmentsByDoctor(doctorId);
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> getPatientAppointments(@PathVariable int patientId) {
        return appointmentService.getAppointmentsByPatient(patientId);
    }
}

