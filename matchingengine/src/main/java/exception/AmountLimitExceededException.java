package exception;
import model.TradeType;

public class AmountLimitExceededException extends RuntimeException {
    public AmountLimitExceededException(TradeType tradeType, double actualValue) {
        super(String.format(
                "%s order value %.2f exceeds maximum allowed %.2f",
                tradeType,
                actualValue,
                tradeType.getMaxAmount()
        ));
    }
}
