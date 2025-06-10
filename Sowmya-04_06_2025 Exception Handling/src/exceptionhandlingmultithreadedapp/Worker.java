package exceptionhandlingmultithreadedapp;
import java.util.Random;

class Worker implements Runnable {
    private int taskId;
    private ExceptionLogger exceptionLogger;

    public Worker(int taskId, ExceptionLogger exceptionLogger) {
        this.taskId = taskId;
        this.exceptionLogger = exceptionLogger;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());

            if (new Random().nextBoolean()) {
                throw new RuntimeException("Task " + taskId + " failed unexpectedly!");
            }

            Thread.sleep(1000);
            System.out.println("Task " + taskId + " completed.");

        } catch (Exception e) {
            exceptionLogger.logException(Thread.currentThread().getName(), e);
        }
    }
}
