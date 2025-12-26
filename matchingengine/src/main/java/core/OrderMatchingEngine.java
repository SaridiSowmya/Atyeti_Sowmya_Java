package core;
import Interface.MatchingEngine;
import exception.DuplicateOrderIdException;
import exception.TradingException;
import model.Order;
import model.OrderType;
import model.Trade;
import model.TradeType;
import validation.OrderValidator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;


public class OrderMatchingEngine implements MatchingEngine {

    private final Map<TradeType, OrderBook> books = new ConcurrentHashMap<>();
    private final Map<String, Order> allOrders = new ConcurrentHashMap<>();
    private final TradeExecutor executor = new TradeExecutor(this);
    private final ExecutorService matcherPool = Executors.newFixedThreadPool(4);

    public OrderMatchingEngine() {
        for (TradeType type : TradeType.values()) {
            books.put(type, new OrderBook(type));
        }
        // this.executor = new TradeExecutor(this);
    }

    public void submitOrder(Order order) throws TradingException {
        // 1. Duplicate check
        if (allOrders.containsKey(order.getOrderId())) {
            throw new DuplicateOrderIdException(order.getOrderId());
        }

        // 2. Full validation
        OrderValidator.validate(order);

        // 3. Register order
        allOrders.put(order.getOrderId(), order);
        OrderBook book = books.get(order.getTradeType());
        book.addOrder(order);

        // 4. Trigger matching asynchronously (non-blocking)
        matcherPool.submit(() -> matchInBook(book));

    }

    private void matchInBook(OrderBook book) {
        while (true) {
            Order bestBuy = book.peekBestBuy();
            Order bestSell = book.peekBestSell();

            if (bestBuy == null || bestSell == null) break;
            if (bestBuy.getPrice() < bestSell.getPrice()) break;



            int tradeQty = Math.min(bestBuy.getRemainingQuantity(), bestSell.getRemainingQuantity());

            // Price: use sell price if sell came first (standard exchange rule)

            double tradePrice = bestSell.getTimestamp().isBefore(bestBuy.getTimestamp())
                    ? bestSell.getPrice() : bestBuy.getPrice();

            //locks both orders to avoid race conditions
            synchronized (bestBuy) {
                synchronized (bestSell) {
                    if (!bestBuy.isFilled() && !bestSell.isFilled() && bestBuy.getPrice() >= bestSell.getPrice()) {
                        executor.execute(bestBuy, bestSell, tradeQty, tradePrice);
                    }
                }
            }
        }
    }

    public List<Trade> getTrades() {
        return executor.getTrades();
    }

    public void shutdown() {
       matcherPool.shutdown();
           try {
              matcherPool.awaitTermination(10, TimeUnit.SECONDS);
           } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
            }
      }




}

