package producerconsumer;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class CameraProducer implements Runnable {
    private final BlockingQueue<byte[]> queue;
    private final String name;
    private final Random random = new Random();

    public CameraProducer(BlockingQueue<byte[]> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        int frameId = 1;
        try {
            while (!Thread.currentThread().isInterrupted()) {
                byte[] frame = new byte[1024];
                random.nextBytes(frame);

                queue.put(frame);
                System.out.printf(" %s produced frame %d\n", name, frameId++);
                Thread.sleep(500 + random.nextInt(500));
            }
        } catch (InterruptedException e) {
            System.out.printf(" %s interrupted.\n", name);
        }
    }
}


