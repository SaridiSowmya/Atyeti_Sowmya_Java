package countdownlatch;
import java.util.concurrent.CountDownLatch;


public class ServiceTask implements Runnable{
    private final String serviceName;
    private final int initTime;
    private final CountDownLatch latch;

    public ServiceTask(String serviceName, int initTime, CountDownLatch latch) {
        this.serviceName = serviceName;
        this.initTime = initTime;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(serviceName + " is starting...");
            Thread.sleep(initTime);
            System.out.println(serviceName + " is UP.");
        } catch (InterruptedException e) {
            System.out.println(serviceName + " startup interrupted.");
        } finally {
            latch.countDown();
        }
    }
}


