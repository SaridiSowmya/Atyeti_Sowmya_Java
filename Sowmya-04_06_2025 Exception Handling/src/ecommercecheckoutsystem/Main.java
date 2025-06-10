package ecommercecheckoutsystem;

import ecommercecheckoutsystem.controller.CheckOutController;

public class Main {
    public static void main(String[] args) {

        CheckOutController controller = new CheckOutController();
        controller.handleCheckout("user123", "prod567", 2, "123 Street", 150.0);

        //controller.handleCheckout("user123", "prod567", 99, "123 Street", 150.0); // Inventory error
        // controller.handleCheckout("user123", "prod567", 2, null, 150.0); // Shipping error
    }
}
