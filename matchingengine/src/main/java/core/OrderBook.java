package core;
import Interface.OrderBooks;
import model.Order;
import model.OrderType;
import model.TradeType;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;


public class OrderBook implements OrderBooks {

    private final TradeType tradeType;

    // BUY: Highest price first → then earliest timestamp
    private final PriorityBlockingQueue<Order> buyOrders = new PriorityBlockingQueue<>(
            1000,
            Comparator.comparingDouble(Order::getPrice).reversed()
                    .thenComparing(Order::getTimestamp)
    );

    // SELL: Lowest price first → then earliest timestamp
    private final PriorityBlockingQueue<Order> sellOrders = new PriorityBlockingQueue<>(
            1000,
            Comparator.comparingDouble(Order::getPrice)
                    .thenComparing(Order::getTimestamp)
    );

    private final Map<String, Order> activeOrders = new HashMap<>();

    public OrderBook(TradeType tradeType) {
        this.tradeType = tradeType;
    }

    public synchronized void addOrder(Order order) {
        activeOrders.put(order.getOrderId(), order);
        if (order.getOrderType() == OrderType.BUY) {
            buyOrders.offer(order);
        } else {
            sellOrders.offer(order);
        }
    }

    public Order peekBestBuy() {
        Order od = buyOrders.peek();
        while (od != null && od.isFilled()) {
            buyOrders.poll();
            od = buyOrders.peek(); //look at the next best order
        }
        return od;
    }

    public Order peekBestSell() {
        Order or = sellOrders.peek();
        while (or != null && or.isFilled()) {
            sellOrders.poll();
            or = sellOrders.peek();
        }
        return or;
    }

    public Order pollBestBuy() {
        Order od = buyOrders.poll();
        if (od!= null && od.isFilled()) return pollBestBuy();
        return od;
    }

    public Order pollBestSell() {
        Order or = sellOrders.poll();
        if (or != null && or.isFilled()) return pollBestSell();
        return or;
    }

    public TradeType getTradeType() {
        return tradeType;
    }
    public Collection<Order> getActiveOrders() {
        return activeOrders.values();
    }
}
