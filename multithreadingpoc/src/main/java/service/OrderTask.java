package service;

import core.StockManager;
import smartorderprocessingsystem.model.Order;

import java.util.Random;
import java.util.concurrent.Callable;

public class OrderTask implements Callable<String> {
    private final Order order;
    private final StockManager stockManager;
    private final LoggerService logger;

    public OrderTask(Order order, StockManager stockManager, LoggerService logger) {
        this.order = order;
        this.stockManager = stockManager;
        this.logger = logger;
    }

    @Override
    public String call() throws Exception {
        logger.log("Received " + order);
        boolean reserved = stockManager.reserve("itemA", 1);

        if (!reserved) {
            throw new IllegalStateException("Insufficient stock for " + order);
        }

        logger.log("Stock reserved for " + order);
        Thread.sleep(new Random().nextInt(4000));

        logger.log("Payment processed for " + order);
        logger.log("Shipped " + order);
        return order + " successfully processed.";
    }
}




