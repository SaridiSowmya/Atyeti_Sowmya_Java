package basic.ordersystem;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderProcessingSystem {
    public static void main(String[] args) {
        BlockingQueue<Order> queue = new LinkedBlockingQueue<>(10);
        ExecutorService consumers = Executors.newFixedThreadPool(3);

        Thread producer = new Thread(new OrderProducer(queue));
        producer.start();

        for (int i = 0; i < 3; i++) {
            consumers.submit(new OrderConsumer(queue));
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            consumers.shutdownNow();
            producer.interrupt();
        }));
    }
}

