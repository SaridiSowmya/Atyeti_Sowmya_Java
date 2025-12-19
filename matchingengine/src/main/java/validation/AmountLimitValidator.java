package validation;

import exception.AmountLimitExceededException;
import model.Order;
import model.TradeType;

public class AmountLimitValidator {
    public static void validate(Order order) throws AmountLimitExceededException {
        double value = order.getPrice() * order.getOriginalQuantity();
        TradeType type = order.getTradeType();
        if (value > type.getMaxAmount()) {
            throw new AmountLimitExceededException(type, value);
        }
    }
}
