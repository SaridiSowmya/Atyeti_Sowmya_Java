package advanced.timeouttaskrunner;
import java.util.concurrent.*;


public class TaskTimeOutDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> longTask = () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Working... " + i);
                Thread.sleep(1000);
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Task interrupted at iteration " + i);
                    return "Aborted";
                }
            }
            return "Completed Successfully";
        };

        Future<String> future = executor.submit(longTask);

        try {
            String result = future.get(5, TimeUnit.SECONDS);
            System.out.println(" Task Result: " + result);
        } catch (TimeoutException e) {
            System.out.println("Task took too long. Cancelling...");
            future.cancel(true);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
        }
    }
}




