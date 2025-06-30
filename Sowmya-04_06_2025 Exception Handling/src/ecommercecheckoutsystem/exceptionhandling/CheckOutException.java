package ecommercecheckoutsystem.customexceptions;

public class CheckOutException extends Exception {
    public CheckOutException(String message,Throwable cause) {
        super(message,cause);
    }
}
