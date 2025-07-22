package ecommerceplatform.model;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String userId;
    private List<CartItem> items;
    private double totalPrice;
    private LocalDateTime timestamp;

    public Order(String userId, List<CartItem> items, double totalPrice, LocalDateTime timestamp) {
        this.userId = userId;
        this.items = items;
        this.totalPrice = totalPrice;
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }
    public List<CartItem> getItems() {
        return items;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setItems(List<CartItem> items) {
        this.items = items;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}



