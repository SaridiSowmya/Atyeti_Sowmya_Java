package orderProcessingSystem;

    public class PayPallPayment implements Payment {

        private String email;

        public PayPallPayment(String email) {
            this.email = email;
        }

        public void pay(double amount) {
            System.out.println("Processing PayPal payment of $" + amount + " for " + email + "...");
        }
    }


