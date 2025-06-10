package ecommercecheckoutsystem.controller;

import ecommercecheckoutsystem.service.CheckOutService;

public class CheckOutController {
    private CheckOutService checkoutService = new CheckOutService();

    public void handleCheckout(String userId, String productId, int quantity, String address, double amount) {
        try {
            checkoutService.performCheckout(userId, productId, quantity, address, amount);
            System.out.println("Checkout completed successfully.");
        } catch (Exception e) {
            System.err.println("User Message: An error occurred during checkout. Please try again later.");

            System.err.println("Developer Log: " + e.getMessage());
            Throwable cause = e.getCause();
            while (cause != null) {
                System.err.println("Caused by: " + cause.getClass().getSimpleName() + " - " + cause.getMessage());
                cause = cause.getCause();
            }
        }
    }
}
