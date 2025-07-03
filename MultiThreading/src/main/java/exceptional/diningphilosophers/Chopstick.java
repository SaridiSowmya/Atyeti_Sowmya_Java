package exceptional.diningphilosophers;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Chopstick {
    private final int id;

    public Chopstick(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Chopstick-" + id;
    }

}


