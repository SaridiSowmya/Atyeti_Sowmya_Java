package BillingEngine;
import java.util.Random;
import java.util.UUID;


public class BillingEngine {
    public String processBilling(String userId, double amount) {
        String traceId = UUID.randomUUID().toString();
        try {
            chargeUser(userId, amount);
            generateInvoice(userId, amount);
            return "Billing completed successfully for user: " + userId;

        } catch (PaymentGatewayException e) {
            AuditTrailExceptionLogger.log(e, traceId);
            return " Payment failed. Please try again later. [Ref: " + traceId + "]";

        } catch (InvalidCardException e) {
            AuditTrailExceptionLogger.log(e, traceId);
            return " Invalid card details. Please update your card info. [Ref: " + traceId + "]";

        } catch (InvoiceGenerationException e) {
            AuditTrailExceptionLogger.log(e, traceId);
            return "Could not generate invoice at this time. [Ref: " + traceId + "]";

        } catch (Exception e) {
            AuditTrailExceptionLogger.log(e, traceId);
            return " Unexpected error occurred. Please contact support. [Ref: " + traceId + "]";
        }
    }

    private void chargeUser(String userId, double amount)
            throws PaymentGatewayException, InvalidCardException {
        int outcome = new Random().nextInt(3);
        switch (outcome) {
            case 0: throw new PaymentGatewayException("Gateway timeout for user " + userId);
            case 1: throw new InvalidCardException("Card declined for user " + userId);
            default: System.out.println("Charged ₹" + amount + " to user " + userId);
        }
    }

    private void generateInvoice(String userId, double amount)
            throws InvoiceGenerationException {
        boolean fail = new Random().nextBoolean();
        if (fail) {
            throw new InvoiceGenerationException("Invoice system unavailable for user " + userId);
        }
        System.out.println(" Invoice generated for ₹" + amount + " (User: " + userId + ")");
    }
}


