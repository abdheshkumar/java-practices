package collection;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class AtomicIntegerApp {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        LongAdder longAdder = new LongAdder();

        new Thread(new CounterThread(atomicInteger), "thread-01").start();
        new Thread(new CounterThread(atomicInteger), "thread-02").start();
        new Thread(new CounterThread(atomicInteger), "thread-03").start();
        new Thread(new CounterThread(atomicInteger), "thread-04").start();
        new Thread(new CounterThread(atomicInteger), "thread-05").start();
        new Thread(new CounterThread(atomicInteger), "thread-06").start();

    }

}

class CounterThread implements Runnable {
    final private AtomicInteger atomicInteger;

    public CounterThread(AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : " + atomicInteger.getAndIncrement());
    }
}