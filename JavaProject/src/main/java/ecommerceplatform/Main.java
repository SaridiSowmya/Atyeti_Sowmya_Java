package ecommerceplatform;
import ecommerceplatform.model.Product;
import ecommerceplatform.model.User;
import ecommerceplatform.service.AuthService;
import ecommerceplatform.service.CartService;
import ecommerceplatform.service.OrderService;
import ecommerceplatform.service.ProductService;
import ecommerceplatform.util.DiscountUtil;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static CartService cartService = new CartService();
    private static User currentUser;

    public static void main(String[] args) {
        System.out.println(" Welcome to the Console E-Commerce Platform!");

        while (true) {
            System.out.println("\n1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.print("Select option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> login();
                case 2 -> register();
                case 0 -> {
                    System.out.println("Thankyou for visiting!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void login() {
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        User user = AuthService.login(username, password);
        if (user != null) {
            currentUser = user;
            System.out.println(" Logged in as: " + currentUser.getRole());
            if (currentUser.getRole() == User.Role.ADMIN) {
                adminMenu();
            } else {
                userMenu();
            }
        } else {
            System.out.println(" Invalid credentials.");
        }
    }

    private static void register() {
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        System.out.print("Role (ADMIN/USER): ");
        String roleStr = sc.nextLine().toUpperCase();

        try {
            User.Role role = User.Role.valueOf(roleStr);
            AuthService.register(username, password, role);
            System.out.println(" Registration successful.");
        } catch (IllegalArgumentException e) {
            System.out.println(" Invalid role.");
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\n Admin Menu");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product Stock");
            System.out.println("0. Logout");
            System.out.print("Select: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> updateStock();
                case 0 -> {
                    System.out.println(" Logged out.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Product name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        ProductService.addProduct(name, price, quantity);
        System.out.println(" Product added.");
    }

    private static void viewProducts() {
        System.out.println("\n Available Products:");
        for (Product p : ProductService.getAllProducts()) {
            System.out.printf("ID: %d | %s | %.2f | Stock: %d\n",
                    p.getId(), p.getName(), p.getPrice(), p.getQuantity());
        }
    }

    private static void userMenu() {
        while (true) {
            System.out.println("\n User Menu");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("0. Logout");
            System.out.print("Select: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> viewProducts();
                case 2 -> addToCart();
                case 3 -> cartService.viewCart();
                case 4 -> checkout();
                case 0 -> {
                    System.out.println(" Logged out.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addToCart() {
        System.out.print("Enter Product ID: ");
        int productId = sc.nextInt();
        System.out.print("Quantity: ");
        int qty = sc.nextInt();
        sc.nextLine();

        Product p = ProductService.findById(productId);
        if (p != null && p.getQuantity() >= qty) {
            cartService.addToCart(p, qty);
            System.out.println(" Added to cart.");
        } else {
            System.out.println(" Product not found or insufficient quantity.");
        }
    }

    private static void updateStock() {
        System.out.print("Enter Product ID to update: ");
        int productId = sc.nextInt();
        sc.nextLine();
        Product product = ProductService.findById(productId);

        if (product != null) {
            System.out.print("Enter new quantity: ");
            int newQty = sc.nextInt();
            sc.nextLine();
            ProductService.updateStockQuantity(productId, newQty);
            System.out.println(" Product stock updated.");
        } else {
            System.out.println(" Product not found.");
        }
    }


    private static void checkout() {
        double total = cartService.calculateTotal();
        OrderService.checkout(currentUser.getUsername(), cartService.getItems(), total);
        System.out.println(DiscountUtil.getDiscountMessage(total, DiscountUtil.applyDiscount(total)));
        cartService.clearCart();
    }
}



