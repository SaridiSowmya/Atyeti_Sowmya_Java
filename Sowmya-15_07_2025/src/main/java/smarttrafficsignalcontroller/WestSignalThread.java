package smarttrafficsignalcontroller;


public class WestSignalThread extends Thread {
    private final SignalManager manager;

    public WestSignalThread(SignalManager manager) {
        this.manager = manager;
        this.setName("WestSignalThread");
    }

    @Override
    public void run() {
        while (true) {
            synchronized (manager.lock) {
                while (!manager.currentSignal.equals("West")) {
                    try {
                        manager.lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println(getName() + " interrupted.");
                        return;
                    }
                }

                if (manager.westCount >= manager.MAX_CYCLES) {
                    manager.currentSignal = "North";
                    manager.lock.notifyAll();
                    return;
                }
                manager.westCount++;
                System.out.println("\n" + getName() + " [Cycle " + manager.westCount + "] -> GREEN");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(getName() + " interrupted during sleep.");
                    return;
                }

                System.out.println(getName() + " -> RED");
                Thread.yield();

                manager.currentSignal = "North";
                manager.lock.notifyAll();
            }
        }
    }
}
