package ecommerceplatform.service;
import ecommerceplatform.model.CartItem;
import ecommerceplatform.model.Order;
import ecommerceplatform.util.DiscountUtil;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

public class OrderService {
    private static final String ORDER_FILE = "C:\\Users\\SowmyaSaridi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sowmya_Java\\JavaProject\\src\\main\\java\\ecommerceplatform\\data\\orders.csv";

    public static void checkout(String userId, List<CartItem> items, double total) {
        double discounted = DiscountUtil.applyDiscount(total);
        Order order = new Order(userId, items, discounted, LocalDateTime.now());
        saveOrder(order);
        for (CartItem item : items) {
            ProductService.updateProductQuantity(item.getProduct().getId(), item.getQuantity());
        }
        System.out.printf(" Order placed successfully!\nFinal price after discount: %.2f\n", discounted);
    }

    private static void saveOrder(Order order) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ORDER_FILE, true))) {
            for (CartItem item : order.getItems()) {
                bw.write(order.getUserId() + "," +
                        item.getProduct().getName() + "," +
                        item.getQuantity() + "," +
                        item.getProduct().getPrice() + "," +
                        item.getTotalPrice() + "," +
                        order.getTimestamp());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(" Error saving order: " + e.getMessage());
        }
    }
}
