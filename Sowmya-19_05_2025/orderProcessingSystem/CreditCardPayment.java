package orderProcessingSystem;

import orderProcessingSystem.Payment;

public class CreditCardPayment implements Payment {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    public void pay(double amount) {
        System.out.println("Processing credit card payment of $" + amount + " for " + cardHolder + "...");
    }
}
