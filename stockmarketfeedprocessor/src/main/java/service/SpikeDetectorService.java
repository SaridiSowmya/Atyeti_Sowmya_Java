package service;
import model.SpikeInfo;
import model.Stock;
import java.util.*;
import java.util.stream.Collectors;

public class SpikeDetectorService {
    public Map<String, List<SpikeInfo>> detectSpikes(List<Stock> stockList) {
        Map<String, List<SpikeInfo>> spikeMap = new HashMap<>();
        stockList.stream()
                .collect(Collectors.groupingBy(Stock::getSymbol))
                .forEach((symbol, stocks) -> {
                    List<Stock> sortedStocks = stocks.stream()
                            .sorted(Comparator.comparing(Stock::getTimestamp))
                            .toList();
                    double minPrice = Double.MAX_VALUE;
                    Stock baseStock = null;
                    for (Stock stock : sortedStocks) {

                        // Update base price first
                        if (baseStock == null || stock.getPrice() < minPrice) {
                            minPrice = stock.getPrice();
                            baseStock = stock;
                            continue;
                        }

                        // Detect spike only if baseStock exists
                        if (baseStock != null && stock.getPrice() > minPrice * 1.10) {
                            SpikeInfo info = new SpikeInfo(
                                    symbol,
                                    stock.getTimestamp(),
                                    stock.getPrice(),
                                    baseStock.getPrice()
                            );

                            spikeMap
                                    .computeIfAbsent(symbol, k -> new ArrayList<>())
                                    .add(info);

                            // Optional reset baseline after spike
                            minPrice = stock.getPrice();
                            baseStock = stock;
                        }
                    }
                });
        return spikeMap;
    }
}

