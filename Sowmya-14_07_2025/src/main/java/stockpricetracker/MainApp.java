package stockpricetracker;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class MainApp {
    public static void main(String[] args) {
        StockPriceService tracker = new StockPriceService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        tracker.recordPrice(LocalDateTime.parse("2025-06-25 09:30", formatter), 150.25);
        tracker.recordPrice(LocalDateTime.parse("2025-06-25 10:00", formatter), 152.75);
        tracker.recordPrice(LocalDateTime.parse("2025-06-25 10:30", formatter), 153.10);
        tracker.recordPrice(LocalDateTime.parse("2025-06-25 11:00", formatter), 154.50);

        System.out.println("Price at or before 10:15:");
        System.out.println(tracker.getPriceAtOrBefore(LocalDateTime.parse("2025-06-25 10:15", formatter)));

        System.out.println("\n Full Price History:");
        for (Map.Entry<LocalDateTime, Double> entry : tracker.getPriceHistory().entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        System.out.println("\n Price History from 09:30 to 10:30:");
        for (Map.Entry<LocalDateTime, Double> entry :
                tracker.getHistoryInRange(
                        LocalDateTime.parse("2025-06-25 09:30", formatter),
                        LocalDateTime.parse("2025-06-25 10:30", formatter)).entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        System.out.println("\n Next price after 10:00:");
        Map.Entry<LocalDateTime, Double> next = tracker.getNextPriceAfter(LocalDateTime.parse("2025-06-25 10:00", formatter));
        if (next != null) {
            System.out.println(next.getKey() + " → " + next.getValue());
        } else {
            System.out.println("No future price available.");
        }
    }
}

