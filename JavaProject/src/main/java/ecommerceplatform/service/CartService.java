package ecommerceplatform.service;
import ecommerceplatform.model.CartItem;
import ecommerceplatform.model.Product;

import java.util.*;

public class CartService {
    private List<CartItem> cart = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        for (CartItem item : cart) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cart.add(new CartItem(product, quantity));
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println(" Cart is empty.");
            return;
        }
        System.out.println(" Your Cart:");
        for (CartItem item : cart) {
            System.out.printf("- %s x%d =  %.2f\n",
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.getTotalPrice());
        }
        System.out.printf("Total: %.2f\n", calculateTotal());
    }

    public List<CartItem> getItems() {
        return cart;
    }

    public void clearCart() {
        cart.clear();
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.getTotalPrice();
        }
        return total;
    }
}



