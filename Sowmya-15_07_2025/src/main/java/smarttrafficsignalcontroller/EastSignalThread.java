package smarttrafficsignalcontroller;

public class EastSignalThread extends Thread {
    private final SignalManager manager;

    public EastSignalThread(SignalManager manager) {
        this.manager = manager;
        this.setName("EastSignalThread");
    }

    @Override
    public void run() {
        while (true) {
            synchronized (manager.lock) {
                while (!manager.currentSignal.equals("East")) {
                    try {
                        manager.lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println(getName() + " interrupted.");
                        return;
                    }
                }
                if (manager.eastCount >= manager.MAX_CYCLES) {
                    manager.currentSignal = "West";
                    manager.lock.notifyAll();
                    return;
                }

                manager.eastCount++;
                System.out.println("\n" + getName() + " [Cycle " + manager.eastCount + "] -> GREEN");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(getName() + " interrupted during sleep.");
                    return;
                }

                System.out.println(getName() + " -> RED");
                Thread.yield();

                manager.currentSignal = "West";
                manager.lock.notifyAll();
            }
        }
    }
}
