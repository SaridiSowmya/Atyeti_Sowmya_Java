package exceptionhandlingmultithreadedapp;

public class ThreadExecution {
    public static void main(String[] args) {
        int numberOfThreads = 5;
        Thread[] threads = new Thread[numberOfThreads];
        ExceptionLogger el = new ExceptionLogger();

        for (int i = 0; i < numberOfThreads; i++) {
            Worker task = new Worker(i + 1, el);
            threads[i] = new Thread(task, "Worker-" + (i + 1));
            threads[i].start();
        }


        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
        }

        el.printReport();

        System.out.println("\nMain thread finished.");
    }

}


