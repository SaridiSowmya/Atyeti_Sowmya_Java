package orderprocessingsystem;
import java.time.LocalDate;

public class Order {
    private String customerName;
    private LocalDate orderDate;
    private double amount;

    public Order(String customerName, LocalDate orderDate, double amount) {
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return customerName + " | " + orderDate + " | $" + amount;
    }
}




