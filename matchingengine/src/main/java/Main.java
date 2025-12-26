import Interface.MatchingEngine;
import core.OrderMatchingEngine;
import model.Trade;
import trading.CSVOrderLoader;
import java.text.NumberFormat;
import java.util.Locale;



public class Main {
    public static void main(String[] args) throws InterruptedException {

        MatchingEngine engine = new OrderMatchingEngine();

        long startTime = System.currentTimeMillis();

        System.out.println("\nMatching in progress");

        CSVOrderLoader.loadOrders(engine);

        engine.shutdown();

        long endTime = System.currentTimeMillis();

        //after matching finishes
        var trades = engine.getTrades();
        printFinalReport(trades, endTime - startTime);
    }
    private static void printFinalReport(java.util.List<Trade> trades, long durationMs) {
        NumberFormat nf = NumberFormat.getInstance(Locale.US);
        //calculates total traded value
        double totalNotional = trades.stream()
                .mapToDouble(t -> t.price() * t.quantity())
                .sum();
        System.out.printf("Total traded notional value : $%,.2f%n", totalNotional);

        System.out.println("FINAL MATCHING SUMMARY");
        System.out.println("===================================");
        System.out.printf("Total BUY  orders processed : %,d  (%,d rejected)%n",
                CSVOrderLoader.buySubmitted, CSVOrderLoader.buyRejected);
        System.out.printf("Total SELL orders processed   : %,d  (%,d rejected)%n",
                CSVOrderLoader.sellSubmitted, CSVOrderLoader.sellRejected);
        System.out.printf("Total valid orders submitted  : %,d%n",
                CSVOrderLoader.buySubmitted + CSVOrderLoader.sellSubmitted);
        System.out.printf("Total trades executed         : %,d%n", trades.size());
        System.out.printf("Matching duration              : %,d ms%n", durationMs);


        System.out.println("\n" + "=".repeat(60));
        System.out.println("               ORDER STATUS SUMMARY");
        System.out.println("=".repeat(60));

        System.out.printf("Fully Filled BUY Orders      : %,d%n", CSVOrderLoader.fullyFilledBuy);
        System.out.printf("Partially Filled BUY Orders  : %,d%n", CSVOrderLoader.partiallyFilledBuy);
        System.out.printf("Fully Filled SELL Orders     : %,d%n", CSVOrderLoader.fullyFilledSell);
        System.out.printf("Partially Filled SELL Orders : %,d%n", CSVOrderLoader.partiallyFilledSell);

        System.out.println("=".repeat(60));

        System.out.println("============================================");
        System.out.println("Sample Executed Trades :");
        System.out.println("============================================");
        //System.out.println("   " + "─".repeat(72));
        // sample trades
        trades.stream().limit(100).forEach(t -> {
            String buyId = t.buyOrderId().length() > 20 ? t.buyOrderId().substring(0, 20) + "..." : t.buyOrderId();
            String sellId = t.sellOrderId().length() > 20 ? t.sellOrderId().substring(0, 20) + "..." : t.sellOrderId();
            System.out.printf("   → %s ↔ %s | %,d @ %.4f  (Notional: $%,.2f)%n",
                    buyId, sellId, t.quantity(), t.price(), t.price() * t.quantity());
        });
//        if (trades.size() > 100) {
//            System.out.printf("   ... and %,d more trades executed%n", trades.size() - 15);
//        }
    }
}



