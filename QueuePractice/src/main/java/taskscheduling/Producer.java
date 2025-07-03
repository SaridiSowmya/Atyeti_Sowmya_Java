package taskscheduling;
import java.util.Random;

public class Producer implements Runnable {
    private final TaskSchedular scheduler;
    private final String name;
    private final Random random = new Random();

    public Producer(TaskSchedular scheduler, String name) {
        this.scheduler = scheduler;
        this.name = name;
    }

    @Override
    public void run() {
        int taskCount = 1;
        while (!scheduler.isShutdown()) {
            int priority = 1 + random.nextInt(10);
            Task task = new Task(name + "-T" + taskCount++, priority);
            scheduler.submit(task);

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException ignored) {}
        }
    }
}


