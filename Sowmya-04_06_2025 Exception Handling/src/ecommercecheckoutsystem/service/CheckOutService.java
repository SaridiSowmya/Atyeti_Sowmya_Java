package ecommercecheckoutsystem.service;

import ecommercecheckoutsystem.exceptionhandling.OutOfStockException;
import ecommercecheckoutsystem.exceptionhandling.PaymentFailedException;
import ecommercecheckoutsystem.exceptionhandling.ShippingServiceException;
import ecommercecheckoutsystem.subsystemsimulator.Inventory;
import ecommercecheckoutsystem.subsystemsimulator.Payment;
import ecommercecheckoutsystem.subsystemsimulator.Shipping;

public class CheckOutService {

    private Payment paymentService = new Payment();
    private Inventory inventoryService = new Inventory();
    private Shipping shippingService = new Shipping();

    public void performCheckout(String userId, String productId, int quantity, String address, double amount) throws Exception {
        try {
            inventoryService.reserveProduct(productId, quantity);
            paymentService.processPayment(userId, amount);
            shippingService.scheduleDelivery(address);
        } catch (OutOfStockException | PaymentFailedException | ShippingServiceException e) {
            throw new Exception("Checkout failed in service layer", e);
        }
    }
}
