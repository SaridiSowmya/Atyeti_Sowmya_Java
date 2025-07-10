package cyclicbarrier;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameStarter {
    public void startGame() {
        int playerCount = 4;

        Runnable barrierAction = () ->
                System.out.println("\n All players ready. Game Started!\n");

        CyclicBarrier barrier = new CyclicBarrier(playerCount, barrierAction);
        ExecutorService executor = Executors.newFixedThreadPool(playerCount);

        for (int i = 1; i <= playerCount; i++) {
            executor.submit(new Player("Player-" + i, barrier));
        }

        executor.shutdown();
    }
}




