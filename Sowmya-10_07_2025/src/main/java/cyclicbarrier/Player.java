package cyclicbarrier;
import java.util.concurrent.CyclicBarrier;

public class Player implements Runnable{
    private final String name;
    private final CyclicBarrier barrier;

    public Player(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }
    @Override
    public void run() {
        try {
            System.out.println(name + " is loading...");
            Thread.sleep((int)(Math.random() * 3000) + 1000);
            System.out.println(name + " is ready. Waiting for others...");
            barrier.await();
            System.out.println(name + " started playing!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


