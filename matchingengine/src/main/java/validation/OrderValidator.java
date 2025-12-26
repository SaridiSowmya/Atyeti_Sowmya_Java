package validation;
import exception.InvalidOrderException;
import exception.TradingException;
import model.Order;

public class OrderValidator {
    public static void validate(Order order) throws TradingException {
         // checking nulls
        if (order == null) {
            throw new InvalidOrderException("Order cannot be null");
        }
        if (order.getOrderId() == null || order.getOrderId().trim().isEmpty()) {
            throw new InvalidOrderException("Order ID cannot be null or empty");
        }
        if (order.getTraderId() == null || order.getTraderId().trim().isEmpty()) {
            throw new InvalidOrderException("Trader ID cannot be null or empty");
        }
        if (order.getCountryCode() == null || order.getCountryCode().trim().isEmpty()) {
            throw new InvalidOrderException("Country code cannot be null or empty");
        }

        //price checking and quantity checking
        if (order.getPrice() <= 0 || order.getOriginalQuantity() <= 0) {
            throw new InvalidOrderException("Price and quantity must be positive");
        }
        CountryValidator.validate(order.getCountryCode());
        AmountLimitValidator.validate(order);
    }
}
