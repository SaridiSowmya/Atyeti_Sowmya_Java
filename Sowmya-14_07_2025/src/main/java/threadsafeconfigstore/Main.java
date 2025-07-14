package threadsafeconfigstore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ConfigurationStore store = new ConfigurationStore();

        Thread writer1 = new Thread(new ConfigWriter(store, "env", "prod"), "Writer-1");
        Thread writer2 = new Thread(new ConfigWriter(store, "env", "dev"), "Writer-2");
        Thread writer3 = new Thread(new ConfigWriter(store, "featureX", "enabled"), "Writer-3");

        Thread reader1 = new Thread(new ConfigReader(store, "env"), "Reader-1");
        Thread reader2 = new Thread(new ConfigReader(store, "featureX"), "Reader-2");
        Thread reader3 = new Thread(new ConfigReader(store, "nonExistentKey"), "Reader-3");


        writer1.start();
        writer2.start();
        writer3.start();


        writer1.join();
        writer2.join();
        writer3.join();


        reader1.start();
        reader2.start();
        reader3.start();


        reader1.join();
        reader2.join();
        reader3.join();

        store.printAllConfigs();
    }
}


