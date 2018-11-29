package patterns.producercustomer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        ItemQueue queue = new ItemQueue();

        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 2; i++) {
            final Producer producer = new Producer("Producer_" + i, queue);

            service.submit(() -> {
                while (true) {
                    producer.produce();
                }
            });
        }

        for (int i = 0; i < 3; i++) {
            final Consumer consumer = new Consumer("Consumer_" + i, queue);

            service.submit(() -> {
                while (true) {
                    consumer.consume();
                }
            });
        }

        service.shutdown();

        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
            service.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
