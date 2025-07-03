package taskscheduling;
import java.util.PriorityQueue;

public class TaskSchedular {
    private final PriorityQueue<Task> queue = new PriorityQueue<>();
    private boolean shutdown = false;

    public synchronized void submit(Task task) {
        if (!shutdown) {
            queue.offer(task);
            notifyAll();
            System.out.println(" Submitted: " + task);
        }
    }

    public synchronized Task take() throws InterruptedException {
        while (queue.isEmpty() && !shutdown) {
            wait();
        }
        return queue.poll();
    }

    public synchronized void shutdown() {
        shutdown = true;
        notifyAll();
        System.out.println(" Scheduler is shutting down...");
    }

    public synchronized boolean isShutdown() {
        return shutdown && queue.isEmpty();
    }
}


