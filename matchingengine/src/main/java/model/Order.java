package model;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Order {
    private final String orderId;
    private final String traderId;
    private final TradeType tradeType;
    private final OrderType orderType;
    private final double price;
    private final int originalQuantity;
    private int remainingQuantity;
    private final String countryCode;
    private final Instant timestamp;
    private OrderStatus status = OrderStatus.PENDING;

    public Order(String orderId, String traderId, TradeType tradeType, OrderType orderType,
                 double price, int quantity, String countryCode, LocalDateTime timestamp) {
        this.orderId = orderId;
        this.traderId = traderId;
        this.tradeType = tradeType;
        this.orderType = orderType;
        this.price = price;
        this.originalQuantity = quantity;
        this.remainingQuantity = quantity;
        this.countryCode = countryCode;
        this.timestamp = timestamp.atZone(ZoneOffset.UTC).toInstant();
    }

    public String getOrderId() { return orderId; }
    public String getTraderId() { return traderId; }
    public TradeType getTradeType() { return tradeType; }
    public OrderType getOrderType() { return orderType; }
    public double getPrice() { return price; }
    public int getOriginalQuantity() { return originalQuantity; }
    public int getRemainingQuantity() { return remainingQuantity; }
    public String getCountryCode() { return countryCode; }
    public Instant getTimestamp() { return timestamp; }
    public OrderStatus getStatus() { return status; }

    public synchronized void fill(int quantity) {
        if (quantity > remainingQuantity) throw new IllegalArgumentException();
        this.remainingQuantity -= quantity;
        this.status = remainingQuantity == 0 ? OrderStatus.FILLED :
                remainingQuantity < originalQuantity ? OrderStatus.PARTIALLY_FILLED : OrderStatus.PENDING;
    }

    public synchronized boolean isFilled() {
        return remainingQuantity == 0;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f x%d @%.4f [%s]",
                orderType, tradeType, price, originalQuantity, price, orderId);
    }
}