package linkedhashmap;

public class Main {
    public static void main(String[] args) {
        LRUcache<Integer, String> cache = new LRUcache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        cache.get(1);
        cache.put(4, "D");

        cache.forEach((k, v) -> System.out.println(k + " → " + v));
    }

}

