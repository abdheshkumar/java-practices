package collection;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalApp {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread: " + Thread.currentThread().getName() + " Formatted date: " + Util.threadSafeFormat(new Date()));
            }
        };

        new Thread(runnable, "Thread-A").start();
        new Thread(runnable, "Thread-B").start();
    }
}

class Util {
    public static String threadSafeFormat(Date date) {
        return DateFormatterThread.getDateFormatter().format(date);
    }
}

class DateFormatterThread {
    private final static ThreadLocal<SimpleDateFormat> dateFormatterHolder = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            System.out.println("Creating SimpleDateFormat Instance for: " + Thread.currentThread().getName());
            return new SimpleDateFormat("dd/MM/yyyy");
        }
    };

    public static DateFormat getDateFormatter() {
        return dateFormatterHolder.get();

    }
}