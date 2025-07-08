package service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LoggerService {
    private final BlockingQueue<String> logQueue = new LinkedBlockingQueue<>();
    private final Thread logWriter;
    private volatile boolean running = true;

    public LoggerService() {
        logWriter = new Thread(() -> {
            while (running || !logQueue.isEmpty()) {
                try {
                    String msg = logQueue.poll(1, TimeUnit.SECONDS);
                    if (msg != null) {
                        System.out.println("[LOG] " + msg);
                    }
                } catch (InterruptedException ignored) {}
            }
        });
        logWriter.start();
    }

    public void log(String msg) {
        logQueue.offer(Thread.currentThread().getName() + " - " + msg);
    }

    public void shutdown() {
        running = false;
        try {
            logWriter.join();
        } catch (InterruptedException ignored) {}
    }
}

