package exceptional.diningphilosophers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiningPhilosophers {
    public static void main(String[] args) {
        int count = 5;
        Chopstick[] chopsticks = new Chopstick[count];
        for (int i = 0; i < count; i++) {
            chopsticks[i] = new Chopstick(i);
        }

        ExecutorService executor = Executors.newFixedThreadPool(count);

        for (int i = 0; i < count; i++)

        {
            Chopstick left = chopsticks[i];
            Chopstick right = chopsticks[(i + 1) % count];
            executor.execute(new Philosopher(i, left, right));
        }


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down...");
            executor.shutdownNow();
        }));

    }

}



