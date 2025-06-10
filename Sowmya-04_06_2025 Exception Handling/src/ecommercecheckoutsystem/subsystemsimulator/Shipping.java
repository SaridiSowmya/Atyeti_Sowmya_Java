package ecommercecheckoutsystem.subsystemsimulator;

import ecommercecheckoutsystem.exceptionhandling.ShippingServiceException;

public class Shipping {
        public void scheduleDelivery(String address) throws ShippingServiceException {
            if (address == null) {
                throw new ShippingServiceException("Invalid address for delivery", new NullPointerException("address"));
            }
        }
}
