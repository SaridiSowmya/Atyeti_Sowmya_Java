package threadsafeconfigstore;
import java.util.concurrent.ConcurrentHashMap;

public class ConfigurationStore {
    private final ConcurrentHashMap<String, String> configs = new ConcurrentHashMap<>();

    public void setConfig(String key, String value) {
        configs.put(key, value);
    }

    public String getConfig(String key) {
        return configs.get(key);
    }

    public String setIfAbsent(String key, String value) {
        return configs.putIfAbsent(key, value);
    }

    public String computeIfMissing(String key, java.util.function.Function<String, String> loader) {
        return configs.computeIfAbsent(key, loader);
    }

    public void printAllConfigs() {
        System.out.println("Current Configs:");
        configs.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}




