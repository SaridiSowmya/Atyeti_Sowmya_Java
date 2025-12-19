package concurrency;
import core.OrderMatchingEngine;
import model.Order;
import model.OrderType;
import model.TradeType;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.concurrent.*;
import static org.junit.jupiter.api.Assertions.*;

public class ConcurrencyTest {

    private static final LocalDateTime BASE_TIME = LocalDateTime.now();

    @Test
    void ThreadsSubmittingOrdersConcurrently() throws Exception {
        OrderMatchingEngine engine = new OrderMatchingEngine();
        ExecutorService submissionPool = Executors.newFixedThreadPool(100);
        CountDownLatch latch = new CountDownLatch(1000); // 1000 orders from 100 threads

        for (int i = 0; i < 1000; i++) {
            final int id = i;
            final LocalDateTime orderTime = BASE_TIME.plusNanos(id * 1000L); // Unique & increasing

            submissionPool.submit(() -> {
                try {
                    Order order = new Order(
                            "CONC-ORD-" + id,
                            "TRADER-" + (id % 50),
                            TradeType.values()[id % 3],
                            id % 2 == 0 ? OrderType.BUY : OrderType.SELL,
                            95.0 + (id % 20),
                            50 + (id % 100),
                            id % 20 == 0 ? "BR" : "US",
                            orderTime
                    );
                    engine.submitOrder(order);
                } catch (Exception ignored) {
                    // Expected: duplicate, country, amount limit
                } finally {
                    latch.countDown();
                }
            });
        }

        // Wait for all orders to be submitted
        boolean allSubmitted = latch.await(20, TimeUnit.SECONDS);
        assertTrue(allSubmitted, "Not all orders were submitted in time!");

        // Give matcher threads time to process everything
        Thread.sleep(5000);
        //engine.shutdown();
        submissionPool.shutdownNow();

        int tradeCount = engine.getTrades().size();
        double totalNotional = engine.getTrades().stream()
                .mapToDouble(t -> t.price() * t.quantity())
                .sum();

        System.out.println("CONCURRENCY TEST RESULT:");
        System.out.println("   Orders submitted : 1000");
        System.out.println("   Trades executed  : " + tradeCount);
        System.out.println("   Total Notional   : $" + String.format("%,.2f", totalNotional));

        // These values will be high because of good price overlap
        assertTrue(tradeCount >= 150,
                "Too few trades! Only " + tradeCount + " (expected 150+) — check price spread");
        assertTrue(totalNotional >= 50_000,
                "Notional too low! Only $" + String.format("%,.2f", totalNotional));
    }
}
