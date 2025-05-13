package Variables;

public class User {
        private int userId;
        private int age;
        private String email;

        public User(int userId, int age, String email) {
            this.userId = userId;
            this.age = age;
            this.email = email;
        }

        public void displayInfo() {
            System.out.println("ID: " + userId + ", Age: " + age + ", Email: " + email);
        }
    }

//meaningful user names with good naming convention