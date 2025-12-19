package validation;
import core.OrderMatchingEngine;
import exception.AmountLimitExceededException;
import exception.DuplicateOrderIdException;
import exception.InvalidCountryException;
import model.Order;
import model.OrderType;
import model.TradeType;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationTest {

    private final LocalDateTime now = LocalDateTime.now();

    @Test
    void testValidOrder() {
        Order order = new Order("O1", "T1", TradeType.EQUITY, OrderType.BUY, 90.0, 1000, "US", now);
        assertDoesNotThrow(() -> OrderValidator.validate(order));
    }

    @Test
    void testInvalidCountry() {
        Order order = new Order("O2", "T1", TradeType.FOREX, OrderType.BUY, 1.08, 100000, "RU", now);
        assertThrows(InvalidCountryException.class, () -> OrderValidator.validate(order));
    }

    @Test
    void testAmountLimitExceeded() {
        Order order = new Order("O3", "T1", TradeType.CRYPTO, OrderType.BUY, 60000, 2, "US", now);
        assertThrows(AmountLimitExceededException.class, () -> OrderValidator.validate(order));
    }

    @Test
    void testDuplicateOrderId() {
        OrderMatchingEngine engine = new OrderMatchingEngine();
        Order order = new Order("DUP1", "T1", TradeType.EQUITY, OrderType.BUY, 100, 100, "US", now);
        assertDoesNotThrow(() -> engine.submitOrder(order));
        assertThrows(DuplicateOrderIdException.class, () -> engine.submitOrder(order));
    }
}