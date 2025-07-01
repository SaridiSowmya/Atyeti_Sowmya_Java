package paymentgateway;
import java.util.Random;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PaymentGateway {
    private static final Logger logger = Logger.getLogger(PaymentGateway.class.getName());
    private static final int MAX_RETRIES = 3;

    public void processPayment(String transactionId, double amount) {
        int attempt = 0;
        boolean success = false;

        while (attempt < MAX_RETRIES && !success) {
            try {
                attempt++;
                simulateApiCall(transactionId, amount);
                success = true;
                System.out.println(" Transaction " + transactionId + " completed on attempt " + attempt);

            } catch (TimeOutException | HttpClientErrorException e) {
                logger.log(Level.WARNING, "Attempt " + attempt + " failed: " + e.getMessage());

                // Retry only if transient
                if (attempt == MAX_RETRIES) {
                    logger.log(Level.SEVERE, " Transaction " + transactionId + " failed after " + MAX_RETRIES + " attempts.");
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, " Critical error in transaction " + transactionId + ": " + e.getMessage());
                break;
            }
        }
    }
    private void simulateApiCall (String transactionId,double amount) throws TimeOutException, HttpClientErrorException {
        Random random = new Random();
        int result = random.nextInt(5);

        switch (result) {
            case 0:
                throw new TimeOutException("Network timeout during transaction " + transactionId);
            case 1:
                throw new HttpClientErrorException("HTTP 400 Bad Request for transaction " + transactionId);
            case 2:
                throw new RuntimeException("Unknown server error for transaction " + transactionId);
            default:
                System.out.println("Processing payment of ₹" + amount + " for transaction " + transactionId);
        }

    }
}



