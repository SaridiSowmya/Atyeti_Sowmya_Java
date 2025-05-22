package restaurantordermanagementsystem;

import java.util.UUID;

public class Order {

    private String orderId;
    private String customerName;
    private MealType mealType;
    private OrderStatus status;

    public Order(String customerName, MealType mealType) {
        this.orderId = UUID.randomUUID().toString();
        this.customerName = customerName;
        this.mealType = mealType;
        this.status = OrderStatus.PLACED; // Default status when created
    }

    public void updateStatus(OrderStatus newStatus) {
        this.status = newStatus;
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Meal Type: " + mealType);
        System.out.println("Order Status: " + status);
        System.out.println("---------------------------");
    }

    public OrderStatus getStatus() {
        return status;
    }




}
