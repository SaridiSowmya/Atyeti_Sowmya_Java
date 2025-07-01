package paymentgateway;

public class PaymentApp {
        public static void main(String[] args) {
            PaymentGateway gateway = new PaymentGateway();

            gateway.processPayment("TXN001", 1200.50);
            gateway.processPayment("TXN002", 750.00);
            gateway.processPayment("TXN003", 9999.99);
        }
}


