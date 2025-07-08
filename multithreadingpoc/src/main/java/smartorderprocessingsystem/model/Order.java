package smartorderprocessingsystem.model;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private static final AtomicInteger ID_GEN = new AtomicInteger(1);
    final int orderId;

    public Order() {
        this.orderId = ID_GEN.getAndIncrement();
    }

    public int getId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order#" + orderId;
    }
}



