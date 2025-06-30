package exceptionhandling.customexceptionhandling;

public class UnauthorizedAccessExceotion extends RuntimeException {
    public UnauthorizedAccessExceotion(String message) {
        super(message);
    }
}
