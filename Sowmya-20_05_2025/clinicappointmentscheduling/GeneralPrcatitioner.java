package clinicappointmentscheduling;

public class GeneralPrcatitioner extends Doctor {

        public GeneralPrcatitioner(String doctorId, String name) {
            super(doctorId, name, "General Practitioner");
        }

        @Override
        public String getAvailability() {
            return "Dr. " + name + " is available Mon–Fri, 10 AM to 4 PM.";
        }
    }





