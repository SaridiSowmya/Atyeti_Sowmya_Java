package ecommercecheckoutsystem.subsystemsimulator;

import ecommercecheckoutsystem.exceptionhandling.OutOfStockException;

public class Inventory {
        public void reserveProduct(String productId, int quantity) throws OutOfStockException {
            if (quantity > 10) {
                throw new OutOfStockException("Product out of stock: " + productId, null);
            }
        }
}
