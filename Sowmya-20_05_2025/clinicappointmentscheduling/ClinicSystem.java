package clinicappointmentscheduling;

import java.time.LocalDate;
import java.util.*;

public class ClinicSystem {
    public static void main(String[] args) {

        Doctor gp = new GeneralPrcatitioner("D001", "bob");
        Doctor sp = new Specialist("D002", "John Smith", "Cardiology");


        Patient p1 = new Patient("P001", "david", 30, "Asthma, Allergy");
        Patient p2 = new Patient("P002", "Davis", 45, "Hypertension");


        Appointment appt1 = new Appointment(p1, gp, LocalDate.of(2025, 5, 22));
        Appointment appt2 = new Appointment(p2, sp, LocalDate.of(2025, 5, 25));


        System.out.println("=== Doctor Availabilities ===");

        System.out.println(gp.getAvailability());
        System.out.println(sp.getAvailability());



        System.out.println("\n=== Appointment Schedule ===");
        System.out.println(appt1.getDetails());
        System.out.println(appt2.getDetails());
        appt2.reschedule(LocalDate.of(2025, 5, 28));
        appt1.cancel();


        System.out.println("\n=== Updated Appointments ===");
        System.out.println(appt1.getDetails());
        System.out.println(appt2.getDetails());

    }

}



