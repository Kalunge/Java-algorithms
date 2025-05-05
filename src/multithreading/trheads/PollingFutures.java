package multithreading.trheads;

import java.util.concurrent.*;

public class PollingFutures {
    static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        example(11);
        executor.shutdown();


    }


    public static int example(int n) throws ExecutionException, InterruptedException {
        int result = -1;
        Callable<Integer> sumTask = new Callable<Integer>() {


            @Override
            public Integer call() throws Exception {
                Thread.sleep(10);
                int sum = 0;
                for (int i = 0; i <= n; i++) {
                    sum += i;
                }

                return sum;
            }
        };

        Callable<Void> randomTask = new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                Thread.sleep(3600 * 1000);
                System.out.println("Random Call");
                return null;
            }
        };

        Future<Integer> future = executor.submit(sumTask);
        Future<Void> future1 = executor.submit(randomTask);

        try {
            future1.cancel(true);
            while (!future.isDone()) {
                System.out.println("Polling the future result");
            }

            System.out.println(future.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1);

                return 5;
            }
        });

        ExecutorService exec = Executors.newSingleThreadExecutor();
        Future duplicateFuture = exec.submit(futureTask);

        while (!futureTask.isDone()) {
            System.out.println("Waiting");
        }

        if (duplicateFuture.isDone() != futureTask.isDone()) {
            System.out.println("This should never happen");
        }

        System.out.println("\nIs second task cancelled : " + future1.isCancelled());
        System.out.println(futureTask.get());


        return result;
    }
}
