package collection;

import java.util.concurrent.*;

//How would you cancel a method execution after time out expires using Java Future ?
public class TimedExecution {
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void timedRun(Runnable runnable, long timeOut, TimeUnit timeUnit) throws InterruptedException, ExecutionException {
        Future<?> submit = executorService.submit(runnable);
        try {
            submit.get(timeOut, timeUnit);
        } catch (TimeoutException e) {
            System.err.println("Timeout occurred");
        } finally {
            submit.cancel(true);
        }
    }

    public void stop() {
        executorService.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TimedExecution timeoutException = new TimedExecution();
        timeoutException.timedRun(() -> {
            while (!Thread.interrupted()) {
                System.out.println("Test me..");
            }
        }, 200, TimeUnit.MILLISECONDS);
        timeoutException.stop();
    }
}
