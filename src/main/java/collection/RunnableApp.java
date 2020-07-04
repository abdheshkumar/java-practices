package collection;

import java.util.Comparator;
import java.util.concurrent.*;

public class RunnableApp {
    public static void main(String[] args) {
        Runnable hellos = () -> {
            for (int i = 1; i <= 10; i++)
                System.out.println("Hello " + i);
        };
        Runnable goodbyes = () -> {
            for (int i = 1; i <= 10; i++)
                System.out.println("Goodbye " + i);
        };
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(hellos);
        executor.execute(goodbyes);

        Callable<String> task = () -> {
            System.out.println("Calling callback...");
            return "Test";
        };
        Future<String> submit = executor.submit(task);
        CompletableFuture<String> f = CompletableFuture.completedFuture("Complete processing");
        f.thenAccept(System.out::println);

        try {
            submit.get(); //blocking until the value is available
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        /*
you omit the executor, the task is run on a default executor (namely the executor returned by ForkJoinPool.commonPool() )
         */
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(
                () -> {
                    String result = "New way to creating future";
                    return result;
                },
                executor);

        f.whenComplete((s, t) -> {
            if (t == null) {
                System.out.println("No Error");
            } else {
                System.out.println("Error: " + t);
            }
        });
        executor.shutdown();
    }
}
