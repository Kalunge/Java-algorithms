package multithreading.trheads;

import java.util.concurrent.*;

public class SumIntegerCallable implements Callable<Integer> {
    int n = 0;

    public SumIntegerCallable(int n) {
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        if (n == 0) return 0;

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }
}

class sumTaskLambda {
    final int n = 0;


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        int n = 11;
        int result = -1;

        Callable<Integer> sumTask = () -> {
            int sum = -1;
//
//            for (int i = 0; i <= n; i++) {
//                sum += i;
//            }
//
//            return sum;
            throw new RuntimeException("Something terrible happened");
        };

        Future<Integer> future = executor.submit(sumTask);
        try {
            System.out.println(future.get());
        } catch (ExecutionException ee) {
            System.out.println(ee.getCause());
        }


        executor.shutdown();



    }
}