package validation;
import exception.InvalidOrderException;
import exception.TradingException;
import model.Order;

public class OrderValidator {
    public static void validate(Order order) throws TradingException {
        if (order.getPrice() <= 0 || order.getOriginalQuantity() <= 0) {
            throw new InvalidOrderException("Price and quantity must be positive");
        }
        CountryValidator.validate(order.getCountryCode());
        AmountLimitValidator.validate(order);
    }
}
