package controlstatements;


import java.util.Scanner;

/**Online Shopping Cart Bill Generator
Simulate a shopping cart system:
        - Add multiple items with quantity and price
- Apply discounts based on total price
- If total > 5000, apply 15% discount, else if > 2000, apply 10%
        Use loops, conditionals, and arithmetic operators.*/

public class OnlineShoppingCartBillGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalAmount = 0.0;
        String choice;

        System.out.println("=== Welcome to the Online Shopping Cart ===");

        do {
            System.out.print("Enter item name: ");
            String item = scanner.nextLine();

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            System.out.print("Enter price per item: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            double itemTotal = quantity * price;
            totalAmount += itemTotal;

            System.out.println(item + " added to cart. Subtotal: " + itemTotal);

            System.out.print("Do you want to add more items? (yes/no): ");
            choice = scanner.nextLine().toLowerCase();

        } while (choice.equals("yes"));

        System.out.println("\nTotal before discount: ₹" + totalAmount);

        double discount = 0.0;

        if (totalAmount > 5000) {
            discount = totalAmount * 0.15; // 15%
        } else if (totalAmount > 2000) {
            discount = totalAmount * 0.10; // 10%
        }

        double finalAmount = totalAmount - discount;

        System.out.println("Discount applied: ₹" + discount);
        System.out.println("Final amount to pay: ₹" + finalAmount);

        //scanner.close();
    }
}


















