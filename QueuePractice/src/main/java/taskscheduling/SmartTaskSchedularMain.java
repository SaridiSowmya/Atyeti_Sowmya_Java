package taskscheduling;

public class SmartTaskSchedularMain {
    public static void main(String[] args) throws InterruptedException {
        TaskSchedular scheduler = new TaskSchedular();


        for (int i = 1; i <= 3; i++) {
            new Thread(new Producer(scheduler, "Producer" + i)).start();
        }


        for (int i = 1; i <= 2; i++) {
            new Thread(new Consumer(scheduler, "Consumer" + i)).start();
        }


        Thread.sleep(10000);
        scheduler.shutdown();
    }
}


