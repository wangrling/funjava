package patterns.producercustomer;

/**
 * Class responsible for consume the {@link Item} produced by {@link Producer}
 */

public class Consumer {

    private final ItemQueue queue;

    private final String name;

    public Consumer(String name, ItemQueue queue) {
        this.name = name;
        this.queue = queue;
    }

    public void consume() throws InterruptedException {
        Item item = queue.take();

        System.out.format("Consumer %s consume item %d produced " +
                "by %s%n", name, item.getId(), item.getProducer());
    }
}
