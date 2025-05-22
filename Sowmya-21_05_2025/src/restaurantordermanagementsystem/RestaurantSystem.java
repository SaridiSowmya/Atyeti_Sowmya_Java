package restaurantordermanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSystem {
        private List<Order> orders;

        public RestaurantSystem() {
            this.orders = new ArrayList<>();
        }

        public void addOrder(Order order) {
            orders.add(order);
            System.out.println("Order added for " + order.getStatus());
        }

        public List<Order> getOrdersByStatus(OrderStatus status) {
            List<Order> filteredOrders = new ArrayList<>();
            for (Order order : orders) {
                if (order.getStatus() == status) {
                    filteredOrders.add(order);
                }
            }
            return filteredOrders;
        }

        public void displayAllOrders() {
            for (Order order : orders) {
                order.displayOrderDetails();
            }
        }
}
