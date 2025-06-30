package ecommercecheckoutsystem.customexceptions;

public class ShippingServiceException extends RuntimeException {
    public ShippingServiceException(String message) {
        super(message);
    }
}
