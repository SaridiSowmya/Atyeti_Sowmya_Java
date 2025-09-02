package com.example.healthcareappointmentsystem.service;

import com.example.healthcareappointmentsystem.model.Appointment;
import com.example.healthcareappointmentsystem.util.DateUtil;
import com.example.healthcareappointmentsystem.util.EmailUtil;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendNotification(Appointment appointment) {
        EmailUtil.sendEmail(
                "admin@hospital.com",
                "Healthcare Notification",
                "Appointment booked for " + appointment.getPatient().getName()
        );

        EmailUtil.sendEmail(
                appointment.getPatient().getContact(),
                "Appointment Confirmation",
                "Dear " + appointment.getPatient().getName() +
                        ", your appointment with Dr. " + appointment.getDoctor().getName() +
                        " has been confirmed on " + DateUtil.format(appointment.getAppointmentTime())
        );

    }
}


