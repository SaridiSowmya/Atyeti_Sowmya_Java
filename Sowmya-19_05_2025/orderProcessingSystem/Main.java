package orderProcessingSystem;

public class Main {
        public static void main(String[] args) {
            Product p1 = new Product(1, "Laptop", 50000.0, 10);
            Product p2 = new Product(2, "Mouse", 500.0, 100);
            Product p3 = new Product(3, "Tab", 5000.0, 50);


            OrderItem item1 = new OrderItem(p1, 1);
            OrderItem item2 = new OrderItem(p2, 1);
            OrderItem item3 = new OrderItem(p3,1);

            Order order = new Order("Alice Smith");
            order.addItem(item1);
            order.addItem(item2);
            order.addItem(item3);


            try {
                order.processOrder("Alice smith");
                double total = order.getTotalAmount();

                // Choose payment method
                Payment payment = new CreditCardPayment("1234-5678-9012-3456", "Alice Smith");
                //Payment payment = new PayPallPayment("alice@example.com");
                //Payment payment = new WalletPayment("WALLET123");

                payment.pay(total);



                System.out.println("Order placed successfully for " + order.getCustomerName()
                        + " on " + order.getOrderDate());


            } catch (InsufficientStockException e) {
                System.out.println("Order failed: " + e.getMessage());
            }
        }
}
