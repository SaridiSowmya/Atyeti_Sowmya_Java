package stockpricetracker;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;


public class StockPriceService {
    private final TreeMap<LocalDateTime, Double> stockPrices = new TreeMap<>();

    public void recordPrice(LocalDateTime time, double price) {
        stockPrices.put(time, price);
    }

    public Double getPriceAtOrBefore(LocalDateTime time) {
        LocalDateTime floorKey = stockPrices.floorKey(time);
        return (floorKey != null) ? stockPrices.get(floorKey) : null;
    }


    public NavigableMap<LocalDateTime, Double> getPriceHistory() {
        return stockPrices;
    }

    public NavigableMap<LocalDateTime, Double> getHistoryInRange(LocalDateTime from, LocalDateTime to) {
        return stockPrices.subMap(from, true, to, true);
    }

    public Map.Entry<LocalDateTime, Double> getNextPriceAfter(LocalDateTime time) {
        return stockPrices.ceilingEntry(time.plusSeconds(1));
    }
}



