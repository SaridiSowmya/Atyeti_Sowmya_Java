package smarttrafficsignalcontroller;

public class SmartTrafficSignalController {
    public static void main(String[] args) {
        SignalManager manager = new SignalManager();

        NorthSignalThread north = new NorthSignalThread(manager);
        EastSignalThread east = new EastSignalThread(manager);
        WestSignalThread west = new WestSignalThread(manager);

        north.start();
        east.start();
        west.start();


       new Thread(() -> {
            try {
                while (north.isAlive() || east.isAlive() || west.isAlive()) {
                    System.out.println(" Alive Status -> North: " + north.isAlive()
                            + ", East: " + east.isAlive() + ", West: " + west.isAlive());
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                System.out.println("Monitor interrupted.");
            }
        }).start();

        try {
            north.join();
            east.join();
            west.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n Traffic Signal Simulation Completed.");
    }
}




