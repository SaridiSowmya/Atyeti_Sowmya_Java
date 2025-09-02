package com.example.healthcareappointmentsystem.service;
import com.example.healthcareappointmentsystem.dto.AppointmentDTO;
import com.example.healthcareappointmentsystem.exception.ResourceNotFoundException;
import com.example.healthcareappointmentsystem.model.*;
import com.example.healthcareappointmentsystem.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepo;
    private final PatientRepository patientRepo;
    private final DoctorRepository doctorRepo;
    private final NotificationService notificationService;

    public Appointment bookAppointment(AppointmentDTO dto) {
        Patient patient = patientRepo.findById(dto.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        Doctor doctor = doctorRepo.findById(dto.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentTime(LocalDateTime.parse(dto.getAppointmentTime()));
        appointment.setStatus("BOOKED");

        Appointment saved = appointmentRepo.save(appointment);

        notificationService.sendNotification(appointment);

        return saved;
    }

    public void cancelAppointment(int appointmentId) {
        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found"));
        appointment.setStatus("CANCELLED");
        appointmentRepo.save(appointment);

        notificationService.sendNotification(appointment);
    }

    public List<Appointment> getAppointmentsByDoctor(int doctorId) {
        return appointmentRepo.findByDoctorId(doctorId);
    }

    public List<Appointment> getAppointmentsByPatient(int patientId) {
        return appointmentRepo.findByPatientId(patientId);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }
}

