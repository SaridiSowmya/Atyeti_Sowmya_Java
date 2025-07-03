package basic.ordersystem;

import java.sql.Timestamp;
import java.util.Date;

public class Order {
    private final int id;
    private final long timestamp;

    public Order(int id) {
        this.id = id;
        this.timestamp = System.currentTimeMillis();
    }

    public int getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", time=" + new Date(timestamp) + '}';
    }
}

