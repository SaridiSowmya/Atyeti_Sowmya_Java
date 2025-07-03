package basic.ordersystem;

import java.util.concurrent.BlockingQueue;

public class OrderProducer implements Runnable{
    private final BlockingQueue<Order> queue;
    private int orderId = 1;

    public OrderProducer(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Order order = new Order(orderId++);
                queue.put(order);
                System.out.println("Produced: " + order);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Producer stopped.");
        }

    }
}




