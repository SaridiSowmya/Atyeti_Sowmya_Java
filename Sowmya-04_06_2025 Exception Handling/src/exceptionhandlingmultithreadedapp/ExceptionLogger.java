package exceptionhandlingmultithreadedapp;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Exceplogger {
    private ConcurrentLinkedQueue<String> errorLogs = new ConcurrentLinkedQueue<>();

    public void logException(String threadName, Exception e) {
            String logEntry = "Thread: " + threadName + " | Exception: " + e.getMessage();
            errorLogs.add(logEntry);
        }

        public void printReport() {
            System.out.println("\n=== Error Report ===");
            if (errorLogs.isEmpty()) {
                System.out.println("No exceptions occurred.");
            } else {
                errorLogs.forEach(System.out::println);
            }
        }
}


