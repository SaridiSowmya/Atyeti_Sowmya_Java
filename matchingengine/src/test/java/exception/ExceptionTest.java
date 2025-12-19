package exception;
import core.OrderMatchingEngine;
import model.Order;
import model.OrderType;
import model.TradeType;
import org.junit.jupiter.api.Test;
import validation.OrderValidator;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {

    private static final LocalDateTime NOW = LocalDateTime.now();

    @Test
    void testDuplicateOrderException() throws Exception {
        OrderMatchingEngine engine = new OrderMatchingEngine();

        Order order = new Order(
                "DUP-001",
                "TRADER-123",
                TradeType.EQUITY,
                OrderType.BUY,
                150.0,
                100,
                "US",
                NOW
        );

        engine.submitOrder(order);
        Order duplicate = new Order(
                "DUP-001", "TRADER-456", TradeType.EQUITY, OrderType.BUY,
                151.0, 50, "US", NOW.plusSeconds(1)
        );

        assertThrows(DuplicateOrderIdException.class, () -> engine.submitOrder(duplicate));
    }

    @Test
    void testInvalidCountryException() {
        Order order = new Order(
                "ORD-001", "TRADER-X", TradeType.FOREX, OrderType.BUY,
                1.0850, 100000, "BR", NOW
        );

        assertThrows(InvalidCountryException.class, () -> OrderValidator.validate(order));
    }

    @Test
    void testAmountLimitExceeded_Crypto() {
        Order order = new Order(
                "ORD-002", "TRADER-BTC", TradeType.CRYPTO, OrderType.BUY,
                60000.0, 1, "US", NOW
        );

        assertThrows(AmountLimitExceededException.class, () -> OrderValidator.validate(order));
    }

    @Test
    void testAmountLimitExceeded_Equity() {
        Order order = new Order(
                "ORD-003", "TRADER-AAPL", TradeType.EQUITY, OrderType.BUY,
                3000.0, 40, "US", NOW
        );

        assertThrows(AmountLimitExceededException.class, () -> OrderValidator.validate(order));
    }

    @Test
    void testAmountLimitExceeded_Forex() {
        Order order = new Order(
                "ORD-004", "TRADER-EUR", TradeType.FOREX, OrderType.BUY,
                1.10, 600000, "US", NOW
        );

        assertThrows(AmountLimitExceededException.class, () -> OrderValidator.validate(order));
    }

    @Test
    void testInvalidData_NegativePrice() {
        Order order = new Order(
                "ORD-005", "TRADER-X", TradeType.EQUITY, OrderType.BUY,
                -99.0, 100, "US", NOW
        );

        assertThrows(InvalidOrderException.class, () -> OrderValidator.validate(order));
    }

    @Test
    void testInvalidData_ZeroQuantity() {
        Order order = new Order(
                "ORD-006", "TRADER-X", TradeType.CRYPTO, OrderType.SELL,
                50000.0, 0, "US", NOW
        );

        assertThrows(InvalidOrderException.class, () -> OrderValidator.validate(order));
    }

    @Test
    void testInvalidData_NegativeQuantity() {
        Order order = new Order(
                "ORD-007", "TRADER-X", TradeType.FOREX, OrderType.BUY,
                1.08, -500, "US", NOW
        );

        assertThrows(InvalidOrderException.class, () -> OrderValidator.validate(order));
    }
}