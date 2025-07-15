package smarttrafficsignalcontroller;

public class SignalManager {
    public final Object lock = new Object();
    public volatile String currentSignal = "North";
    //public volatile int cycleCount = 0;
    public final int MAX_CYCLES = 3;

    public volatile int northCount = 0;
    public volatile int eastCount = 0;
    public volatile int westCount = 0;
}

