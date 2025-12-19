package core;
import model.Order;
import model.OrderStatus;
import model.OrderType;
import model.TradeType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class MatchingTest {

    @Test
    void testPerfectMatch() throws Exception {
        OrderMatchingEngine engine = new OrderMatchingEngine();
        LocalDateTime now = LocalDateTime.now();
        Order buy = new Order("B1", "T1", TradeType.EQUITY, OrderType.BUY, 100.0, 100, "US", now);
        Order sell = new Order("S1", "T2", TradeType.EQUITY, OrderType.SELL, 100.0, 100, "UK", now.plusSeconds(1));
        engine.submitOrder(buy);
        engine.submitOrder(sell);
        Thread.sleep(100);
        assertEquals(1, engine.getTrades().size());
        assertEquals(OrderStatus.FILLED, buy.getStatus());
        assertEquals(OrderStatus.FILLED, sell.getStatus());
    }

    @Test
    void testPartialFill() throws Exception {
        OrderMatchingEngine engine = new OrderMatchingEngine();
        LocalDateTime now = LocalDateTime.now();

        Order largeSell = new Order("S1", "T1", TradeType.FOREX, OrderType.SELL, 1.0850, 10000, "US", now);
        Order smallBuy = new Order("B1", "T2", TradeType.FOREX, OrderType.BUY, 1.0850, 3000, "SG", now.plusSeconds(1));

        engine.submitOrder(largeSell);
        engine.submitOrder(smallBuy);

        Thread.sleep(100);
        assertEquals(1, engine.getTrades().size());
        assertEquals(OrderStatus.PARTIALLY_FILLED, largeSell.getStatus());
        assertEquals(7000, largeSell.getRemainingQuantity());
        assertEquals(OrderStatus.FILLED, smallBuy.getStatus());
    }
}