package BillingEngine;
import java.time.LocalDateTime;
import java.util.UUID;


public class AuditTrailExceptionLogger {
    public static void log(Exception e, String traceId) {

        System.out.println(" [AUDIT-LOG] Time: " + LocalDateTime.now());
        System.out.println("Trace ID: " + traceId);
        System.out.println("Exception Type: " + e.getClass().getSimpleName());
        System.out.println("Message: " + e.getMessage());
        System.out.println(" Stack Trace:");
        e.printStackTrace(System.out);
        System.out.println("--------------------------------------------------------");
    }
}
