package collection;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockApp {
    public static void main(String[] args) {
        Lock countLock = new ReentrantLock(); // Shared among multiple threads
        int count = 0; // Shared among multiple threads
        countLock.lock();
        try {
            count++; // Critical section
        } finally {
            System.out.println(count);
            countLock.unlock(); // Make sure the lock is unlocked
        }
    }
}
