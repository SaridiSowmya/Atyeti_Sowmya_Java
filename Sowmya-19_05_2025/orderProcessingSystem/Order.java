package orderProcessingSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private String customerName;
    private Date orderDate;
    private List<OrderItem> items;

    public Order(String customerName) {
        this.customerName = customerName;
        this.orderDate = new Date();
        this.items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double getTotalAmount() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void processOrder(String name) throws InsufficientStockException {
        for (OrderItem item : items)
        {
            item.getProduct().reduceStock(item.getQuantity());
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
