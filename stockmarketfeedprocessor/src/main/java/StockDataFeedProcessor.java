import model.SpikeInfo;
import model.Stock;
import model.StockMetrics;
import service.SpikeDetectorService;
import service.StockLoggerService;
import service.StockMetricsCalculator;
import task.CsvFolderTask;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class StockDataFeedProcessor {
    public static void main(String[] args) {

        //read the input files
        String path = "C:\\Users\\SowmyaSaridi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sowmya_Java\\stockmarketfeedprocessor\\src\\main\\resources";

        File folder = new File(path);

        if (!folder.exists() || !folder.isDirectory()) {
            throw new RuntimeException("Invalid folder path: " + path);
        }

        ForkJoinPool pool = new ForkJoinPool();
        CsvFolderTask task = new CsvFolderTask(folder);

        List<Stock> stocks = pool.invoke(task);

        System.out.println("\n==== ALL STOCK RECORDS ====\n");
        stocks.forEach(System.out::println);
        System.out.println("Total Records = " + stocks.size());

        //Calculate real-time metrics: min, max, average, moving average (SMA).

        StockMetricsCalculator calculator = new StockMetricsCalculator();
        Map<String, Stock> minMaxStocks = calculator.getMinMaxStocks(stocks);
        System.out.println(minMaxStocks);


        // Per stock metrics
        Map<String, StockMetrics> metricsMap = calculator.calculateMetrics(stocks);
        System.out.println("\n==== STOCK METRICS ====");
        metricsMap.forEach((symbol, metrics) -> {
            System.out.println(symbol + " -> " + metrics);
        });

        // Example SMA calculation (window size 3)
        System.out.println("\n==== MOVING AVERAGE (SMA) ====");
        List<Double> sma = calculator.calculateSMA(stocks, 3);
         System.out.println(sma);

        //Detect spikes (price jumps > 10%).
        SpikeDetectorService detector = new SpikeDetectorService();
        Map<String, List<SpikeInfo>> spikes = detector.detectSpikes(stocks);
        System.out.println("Stocks that are raised than 10% :");
        System.out.println(spikes);

        // Generate per-stock logs in separate files.
        StockLoggerService sl = new StockLoggerService();
        sl.generateLogFilesPerStock(stocks);

    }
}