package threadsafeconfigstore;

public class ConfigWriter implements Runnable{
    private final ConfigurationStore store;
    private final String key;
    private final String value;

    public ConfigWriter(ConfigurationStore store, String key, String value) {
        this.store = store;
        this.key = key;
        this.value = value;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " trying to set: " + key);
        String previous = store.setIfAbsent(key, value);
        if (previous == null) {
            System.out.println(Thread.currentThread().getName() + " successfully set: " + key);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to set (already exists): " + key);
        }
    }
}




