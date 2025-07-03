package basic.ordersystem;

import java.util.concurrent.BlockingQueue;

public class OrderConsumer implements Runnable{
    private final BlockingQueue<Order> queue;

    public OrderConsumer(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Order order = queue.take();
                System.out.println("Consumed by " + Thread.currentThread().getName() + ": " + order);
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumer stopped: " + Thread.currentThread().getName());
        }
    }
}


