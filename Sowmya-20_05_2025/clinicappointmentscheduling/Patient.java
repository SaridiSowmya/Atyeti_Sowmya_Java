package clinicappointmentscheduling;
//patientId, name, age, and medical history.
public class Patient {
        private String patientId;
        private String name;
        private int age;
        private String medicalHistory;

        public Patient(String patientId, String name, int age, String medicalHistory) {
            this.patientId = patientId;
            this.name = name;
            this.age = age;
            this.medicalHistory = medicalHistory;
        }

        public String getPatientId() {
            return patientId;
        }
        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }

        public String getMedicalHistory(boolean authorized) {
            return authorized ? medicalHistory : "Access Denied";
        }

        @Override
        public String toString() {
            return name + " (Age: " + age + ")";
        }
    }


