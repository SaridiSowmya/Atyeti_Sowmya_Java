package clinicappointmentscheduling;

import java.time.LocalDate;

public class Appointment {
        private Patient patient;
        private Doctor doctor;
        private LocalDate appointmentDate;
        private String status;

        public Appointment(Patient patient, Doctor doctor, LocalDate appointmentDate) {
            this.patient = patient;
            this.doctor = doctor;
            this.appointmentDate = appointmentDate;
            this.status = "Scheduled";
        }

        public void cancel() {
            this.status = "Cancelled";
        }

        public void reschedule(LocalDate newDate) {
            this.appointmentDate = newDate;
            this.status = "Rescheduled";
        }

        public String getDetails() {
            return "Appointment: " + patient + " with " + doctor +
                    " on " + appointmentDate + " | Status: " + status;
        }
    }


