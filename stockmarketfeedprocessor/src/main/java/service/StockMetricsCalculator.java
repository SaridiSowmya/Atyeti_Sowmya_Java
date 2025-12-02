package service;
import model.Stock;
import model.StockMetrics;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.*;


public class StockMetricsCalculator {
    public final Logger logger=Logger.getLogger(StockMetricsCalculator.class.getName());

    // Min, Max, Avg per stock symbol
    public Map<String, StockMetrics> calculateMetrics(List<Stock> stocks) {
        return stocks.stream()
                .collect(Collectors.groupingBy(
                        Stock::getSymbol,
                        Collectors.collectingAndThen(
                                Collectors.summarizingDouble(Stock::getPrice),
                                stats -> new StockMetrics(
                                        stats.getMin(),
                                        stats.getMax(),
                                        stats.getAverage()
                                )

                        )
                ));

    }
      // global max amd min
    public Map<String, Stock> getMinMaxStocks(List<Stock> stockList) {
        Map<String, Stock> minMaxStocks = new HashMap<>();
        Optional<Stock> min = stockList.stream().min((s1, s2) -> (int) (s1.getPrice() - s2.getPrice()));
        if (min.isPresent()) {
            Stock stock = min.get();
            minMaxStocks.put("Min Stock (in Price)",stock);
        }
        Optional<Stock> max = stockList.stream().max((s1, s2) -> (int) (s1.getPrice() - s2.getPrice()));
        if (max.isPresent()) {
            Stock stock = max.get();
            minMaxStocks.put("Max Stock (in Price)",stock);
        }
        return minMaxStocks;
    }

    // Simple Moving Average (SMA)
    public List<Double> calculateSMA(List<Stock> stocks, int windowSize) {
        List<Double> smaList = new ArrayList<>();
        stocks.sort(Comparator.comparing(Stock::getTimestamp));
        for (int i = 0; i <= stocks.size() - windowSize; i++) {
            double sum = 0;

            for (int j = i; j < i + windowSize; j++) {
                sum += stocks.get(j).getPrice();
            }
            smaList.add(sum / windowSize);
        }
        return smaList;
    }
}
