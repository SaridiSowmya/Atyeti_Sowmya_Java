package ecommerceplatform.util;

public class DiscountUtil {
    public static double applyDiscount(double total) {
        if (total > 10000) return total * 0.90;  // 10% discount
        if (total > 5000) return total * 0.95;   // 5% discount
        return total;
    }

    public static String getDiscountMessage(double original, double discounted) {
        double saved = original - discounted;
        if (saved > 0) {
            return String.format(" Discount applied! You saved %.2f", saved);
        }
        return "No discount applied.";
    }
}




