package restaurantordermanagementsystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {



        RestaurantSystem system = new RestaurantSystem();


        Order order1 = new Order("Alice", MealType.LUNCH);
        Order order2 = new Order("Bob", MealType.DINNER);

        system.addOrder(order1);
        system.addOrder(order2);


        order1.updateStatus(OrderStatus.PREPARING);
        order1.updateStatus(OrderStatus.READY);
        order1.updateStatus(OrderStatus.SERVED);


        System.out.println("All Orders:");
        system.displayAllOrders();


        System.out.println("Orders with status SERVED:");
        List<Order> servedOrders = system.getOrdersByStatus(OrderStatus.SERVED);
        for (Order order : servedOrders) {
            order.displayOrderDetails();
        }
    }
}

