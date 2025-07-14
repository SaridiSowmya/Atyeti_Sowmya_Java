package threadsafeconfigstore;

public class ConfigReader implements Runnable{
    private final ConfigurationStore store;
    private final String key;

    public ConfigReader(ConfigurationStore store, String key) {
        this.store = store;
        this.key = key;
    }

    @Override
    public void run() {
        String value = store.getConfig(key);
        System.out.println(Thread.currentThread().getName() + " read: " + key + " = " + value);
    }
}


