package clinicappointmentscheduling;

public class Doctor {
        protected String doctorId;
        protected String name;
        protected String specialization;

        public Doctor(String doctorId, String name, String specialization) {
            this.doctorId = doctorId;
            this.name = name;
            this.specialization = specialization;
        }

        public String getDoctorId() {
            return doctorId;
        }
        public String getName() {
            return name;
        }
        public String getSpecialization() {
            return specialization;
        }

        public String getAvailability() {
            return "Doctor " + name + " is available from 9 AM to 5 PM.";
        }

        @Override
        public String toString() {
            return "Dr. " + name + " (" + specialization + ")";
        }
    }



