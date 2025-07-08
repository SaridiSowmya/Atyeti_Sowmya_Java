package main;
import java.util.*;
import java.util.concurrent.*;
import core.StockManager;
import service.LoggerService;
import service.OrderTask;
import smartorderprocessingsystem.model.Order;

public class SmartOrderProcessingSystem {
    public static void main(String[] args) throws InterruptedException{
        ExecutorService executor = Executors.newFixedThreadPool(4);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        LoggerService logger = new LoggerService();
        StockManager stockManager = new StockManager();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.log("Shutdown initiated...");
            executor.shutdownNow();
            scheduler.shutdownNow();
            logger.shutdown();
        }));

        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            OrderTask task = new OrderTask(order, stockManager, logger);
            Future<String> future = executor.submit(task);
            futures.add(future);

            scheduler.schedule(() -> {
                if (!future.isDone()) {
                    future.cancel(true);
                    logger.log(order + " timed out and was cancelled.");
                }
            }, 3, TimeUnit.SECONDS);
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        scheduler.shutdown();
        scheduler.awaitTermination(3, TimeUnit.SECONDS);

        logger.log("All tasks finished. Final stock: " + stockManager.getStockSnapshot());
        logger.shutdown();
    }
}



