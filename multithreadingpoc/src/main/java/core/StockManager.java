package core;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class StockManager{
    private final Map<String, Integer> stock = new HashMap<>();
    private final ReentrantLock lock = new ReentrantLock();

    public StockManager() {
        stock.put("itemA", 5);
        stock.put("itemB", 3);
    }

    public boolean reserve(String item, int qty) {
        lock.lock();
        try {
            int available = stock.getOrDefault(item, 0);
            if (available >= qty) {
                stock.put(item, available - qty);
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    public Map<String, Integer> getStockSnapshot() {
        return new HashMap<>(stock);
    }
}



