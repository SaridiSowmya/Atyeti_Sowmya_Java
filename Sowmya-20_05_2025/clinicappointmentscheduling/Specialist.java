package clinicappointmentscheduling;

public class Specialist extends Doctor{
        public Specialist(String doctorId, String name, String field) {
            super(doctorId, name, "Specialist - " + field);
        }

        @Override
        public String getAvailability() {
            return "Dr. " + name + " is available on appointment basis.";
        }
    }


