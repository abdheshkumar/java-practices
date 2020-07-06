package collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Producer/Consumer problem
public class BlockingQueueWithLock<T> {
    private Queue<T> queue = new LinkedList<>();
    private final int capacity;
    private Lock lock = new ReentrantLock();
    private Condition fullCondition = lock.newCondition();
    private Condition emptyCondition = lock.newCondition();

    public BlockingQueueWithLock(int capacity) {
        this.capacity = capacity;
    }

    public void put(T element) throws InterruptedException {
        lock.lock(); //Acquired lock before going to critical state
        try {
            while (queue.size() == capacity) {
                System.out.println("Waiting to Produce value");
                fullCondition.await();
            }
            queue.add(element);
            emptyCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock(); //Acquired lock before going to critical state
        try {
            while (queue.isEmpty()) {
                System.out.println("Waiting to Consume value");
                emptyCondition.await();

            }
            T element = queue.remove();
            fullCondition.signal();
            return element;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BlockingQueueWithLock<Integer> blockingQueue = new BlockingQueueWithLock(2);
        Runnable producer = () -> {
            Random random = new Random();
            while (true) {
                int element = random.nextInt(10);
                try {
                    blockingQueue.put(element);
                    System.out.println("Produced::" + element);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            Random random = new Random();
            while (true) {
                try {
                    int element = blockingQueue.take();
                    System.out.println("Consumed::" + element);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
