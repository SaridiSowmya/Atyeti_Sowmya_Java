package taskscheduling;

public class Consumer implements Runnable {
    private final TaskSchedular scheduler;
    private final String name;

    public Consumer(TaskSchedular scheduler, String name) {
        this.scheduler = scheduler;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Task task = scheduler.take();
                if (task != null) {
                    System.out.println(" " + name + " picked: " + task);
                    task.execute();
                    Thread.sleep(300);
                } else if (scheduler.isShutdown()) {
                    break;
                }
            } catch (InterruptedException ignored) {}
        }
        System.out.println(" " + name + " finished.");
    }
}


