package app;

import model.StockRecord;
import loader.CsvLoader;
import output.JsonWriter;
import processor.StockForkJoinProcessor;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class StockProcessingApplication {
    public static void main(String[] args) {
        CsvLoader loader = new CsvLoader();
        List<StockRecord> records = loader.loadOrders();


        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new StockForkJoinProcessor(records));

        new JsonWriter().write(records);

        System.out.println("POC completed successfully");

    }
}
