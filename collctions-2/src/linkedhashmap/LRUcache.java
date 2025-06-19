package linkedhashmap;
import java.util.LinkedHashMap;
import java.util.Map;


public class LRUcache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUcache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}


