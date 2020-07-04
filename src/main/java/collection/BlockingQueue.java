package collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

//Producer/Consumer problem
public class BlockingQueue<T> {
    private Queue<T> queue = new LinkedList<>();
    private final int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(T element) throws InterruptedException {
        while (queue.size() == capacity) {
            System.out.println("Waiting to Produce value");
            wait();
        }
        queue.add(element);
        notify();
    }

    public synchronized T take() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Waiting to Consume value");
            wait();
        }
        T element = queue.remove();
        notify();
        return element;
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue(2);
        Runnable producer = () -> {
            Random random = new Random();
            while (true) {
                int element = random.nextInt();
                try {
                    blockingQueue.put(element);
                    System.out.println("Produced::" + element);
                    Thread.sleep(5000);
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
