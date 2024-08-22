import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ProducerConsumerUsingSemaphores {

    public static void main(String[] ar) {
        ExecutorService ex = Executors.newCachedThreadPool();
        Semaphore producer = new Semaphore(5);
        Semaphore consumer = new Semaphore(0);
        Store st = new Store(5);

        for(int i=1; i<=8; i++) {
            Producer pr = new Producer(producer, consumer, st);
            ex.execute(pr);
        }

        for(int i=1; i<=20; i++) {
            Consumer cs = new Consumer(producer, consumer, st);
            ex.execute(cs);
        }

        ex.shutdown();
    }

}

class Store {
    private List<Object> list;
    private int maxSize;

    Store(int maxSize) {
        this.list = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}

class Producer implements Runnable {

    private Semaphore producer;
    private Semaphore consumer;
    private Store store;

    Producer(Semaphore producer, Semaphore consumer, Store store) {
        this.producer = producer;
        this.consumer = consumer;
        this.store = store;
    }

    @Override
    public void run() {
        while(true) {
            try {
                producer.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (store) {
                if (store.getList().size() < store.getMaxSize()) {
                    store.getList().add(new Object());
                    System.out.println("Produced: " + store.getList().size());
                }
            }
            consumer.release();
        }
    }
}

class Consumer implements Runnable {
    private Semaphore producer;
    private Semaphore consumer;
    private Store store;

    Consumer(Semaphore producer, Semaphore consumer, Store store) {
        this.producer = producer;
        this.consumer = consumer;
        this.store = store;
    }

    @Override
    public void run() {
        while(true) {
            try {
                consumer.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (store) {
                if (store.getList().size() > 0) {
                    store.getList().remove(store.getList().size() - 1);
                    System.out.println("Consumed: " + store.getList().size());
                }
            }
            producer.release();
        }
    }
}
