package producerconsumer;
import java.util.concurrent.*;

public class ImageProcessingPipeline {
    public static void main(String[] args) throws InterruptedException {
        int numProducers = 3;
        int numConsumers = 4;
        int queueCapacity = 10;

        LinkedBlockingQueue<byte[]> frameQueue = new LinkedBlockingQueue<>(queueCapacity);

        ExecutorService producerPool = Executors.newFixedThreadPool(numProducers);
        ExecutorService consumerPool = Executors.newFixedThreadPool(numConsumers);


        for (int i = 1; i <= numProducers; i++) {
            producerPool.execute(new CameraProducer(frameQueue, "Camera-" + i));
        }


        for (int i = 1; i <= numConsumers; i++) {
            consumerPool.execute(new FrameConsumer(frameQueue, "Worker-" + i));
        }


        Thread.sleep(10000);


        producerPool.shutdownNow();
        producerPool.awaitTermination(5, TimeUnit.SECONDS);


        for (int i = 0; i < numConsumers; i++) {
            frameQueue.put(FrameConsumer.POISON_PILL);
        }


        consumerPool.shutdown();
        consumerPool.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("Image Processing Pipeline shut down.");
    }
}

