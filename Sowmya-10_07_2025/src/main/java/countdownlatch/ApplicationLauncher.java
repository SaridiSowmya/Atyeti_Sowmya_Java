package countdownlatch;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationLauncher {
    private final int TOTAL_SERVICES = 3;
    private final CountDownLatch latch = new CountDownLatch(TOTAL_SERVICES);

    public void startApplication() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(TOTAL_SERVICES);

        executor.submit(new ServiceTask("Database Service", 3000, latch));
        executor.submit(new ServiceTask("Configuration Service", 2000, latch));
        executor.submit(new ServiceTask("Analytics Service", 4000, latch));

        System.out.println("Main thread is waiting for all services to initialize...");

        latch.await();

        System.out.println("All services initialized. Starting main application logic...");
        executor.shutdown();
    }
}



