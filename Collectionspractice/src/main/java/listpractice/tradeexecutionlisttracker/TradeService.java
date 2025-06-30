package listpractice.tradeexecutionlisttracker;
import java.util.*;
import java.util.stream.Collectors;

public class TradeService {
    private final List<Trade> trades = new ArrayList<>();

    public void addTrade(Trade trade) {
        if (!trades.contains(trade)) {
            trades.add(trade);
        } else {
            System.out.println("Duplicate trade: " + trade.getTradeId());
        }

    }

    public void removeExpiredTrades(String symbol) {
        trades.removeIf(trade -> trade.getSymbol().equalsIgnoreCase(symbol));
    }

    public void sortTradesByTime() {
        trades.sort(Comparator.comparing(Trade::getTimestamp));
    }

    public void getAllTrades() {
        for (Trade t : trades) {
            System.out.println(t);
        }
    }

    public List<Trade> getDistinctTrades() {
        return trades.stream().distinct().collect(Collectors.toList());
    }
}




