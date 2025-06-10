package ecommercecheckoutsystem.subsystemsimulator;

import ecommercecheckoutsystem.exceptionhandling.PaymentFailedException;

public class Payment {
        public void processPayment(String userId, double amount) throws PaymentFailedException {
            throw new PaymentFailedException("Payment gateway timeout", new RuntimeException("HTTP 504"));
        }
    }


