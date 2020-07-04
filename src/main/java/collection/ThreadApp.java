package collection;

public class ThreadApp {
    static Thread startThread() {
        Runnable t = () -> System.out.println("Start new thread "+ Thread.currentThread().getName());
        return new Thread(t,"My-Thread..");
    }

    public static void main(String[] args) {
        System.out.println("Start..");
        Thread t = startThread();
        System.out.println(Thread.currentThread().getName());
        t.start();//start method also starts a new thread
        System.out.println(Thread.currentThread().getName());
        //t.run();//If you call the run method directly then it will run on same thread not on different thread
        System.out.println("End..");
        System.out.println(Thread.currentThread().getName());
    }
}
