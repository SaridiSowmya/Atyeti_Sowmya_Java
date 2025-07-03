package exceptional.diningphilosophers;

public class Philosopher implements Runnable{

    private final int id;
    private final Chopstick left;
    private final Chopstick right ;

    public Philosopher(int id, Chopstick left, Chopstick right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }

    private void think() throws InterruptedException {
        System.out.println(" Philosopher " + id + " is thinking.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        System.out.println(" Philosopher " + id + " is eating.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                Chopstick first = left.getId() < right.getId() ? left : right;
                Chopstick second = left.getId() < right.getId() ? right : left;

                synchronized (first) {
                    System.out.println("Philosopher " + id + " picked up " + first);
                    synchronized (second) {
                        System.out.println("Philosopher " + id + " picked up " + second);
                        eat();
                        System.out.println("Philosopher " + id + " put down " + second);
                    }
                    System.out.println("Philosopher " + id + " put down " + first);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Philosopher " + id + " was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}

