package BillingEngine;

public class BillingApp {
    public static void main(String[] args) {
        BillingEngine engine = new BillingEngine();

        System.out.println(engine.processBilling("user123", 999.99));
        System.out.println(engine.processBilling("user456", 499.00));
    }
}


