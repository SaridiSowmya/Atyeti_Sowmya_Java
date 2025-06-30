package ecommercecheckoutsystem.customexceptions;

public class OutOfStockException extends Exception {
    public OutOfStockException(String message, Throwable cause) {
        super(message,cause);
    }
}

