package producerconsumer;
import java.util.concurrent.BlockingQueue;

public class FrameConsumer implements Runnable {
    private final BlockingQueue<byte[]> queue;
    private final String name;
    public static final byte[] POISON_PILL = new byte[0];

    public FrameConsumer(BlockingQueue<byte[]> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] frame = queue.take();
                if (frame == POISON_PILL) {
                    System.out.printf(" %s received poison pill. Exiting.\n", name);
                    break;
                }

                process(frame);
            }
        } catch (InterruptedException e) {
            System.out.printf(" %s interrupted.\n", name);
        }
    }

    private void process(byte[] frame) throws InterruptedException {

        Thread.sleep(300);
        System.out.printf(" %s processed a frame (size: %d bytes)\n", name, frame.length);
    }
}


