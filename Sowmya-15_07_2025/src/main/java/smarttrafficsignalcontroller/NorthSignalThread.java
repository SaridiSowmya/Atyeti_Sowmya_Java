package smarttrafficsignalcontroller;

public class NorthSignalThread extends Thread {
    private final SignalManager manager;

    public NorthSignalThread(SignalManager manager) {
        this.manager = manager;
        this.setName("NorthSignalThread");
    }

    @Override
    public void run() {
        while (true) {
            synchronized (manager.lock) {
                while (!manager.currentSignal.equals("North")) {
                    try {
                        manager.lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println(getName() + " interrupted.");
                        return;
                    }
                }
                if (manager.northCount >= manager.MAX_CYCLES) {
                    manager.currentSignal = "East";
                    manager.lock.notifyAll();
                    return;
                }

                manager.northCount++;
                System.out.println("\n" + getName() + " [Cycle " + manager.northCount + "] -> GREEN");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(getName() + " interrupted during sleep.");
                    return;
                }

                System.out.println(getName() + " -> RED");
                Thread.yield();

                manager.currentSignal = "East";
                manager.lock.notifyAll();
            }
        }
    }
}
