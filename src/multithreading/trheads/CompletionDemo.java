package multithreading.trheads;

import java.util.*;
import java.util.concurrent.*;

public class CompletionDemo {

    static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws Exception {
        completionService();
    }


    static void completionService() throws Exception {


        class TrivialTask implements Callable<Integer> {
            int n;

            public TrivialTask(int n) {
                this.n = n;
            }

            @Override
            public Integer call() {
                try {
                    Thread.sleep(random.nextInt(101));
                    System.out.println(n * n);
                    n = n * n;
                } catch (InterruptedException e) {
                    // handle exception
                }
                return n;
            }
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<Integer> executorService = new ExecutorCompletionService<>(threadPool);

        for (int i = 0; i < 10; i++) {
            executorService.submit(new TrivialTask(i));
        }

        int count = 10;
        while (count != 0) {
            Future<Integer> f = executorService.take();
            System.out.println("Thread " + f.get() + "  got done");
            count--;
        }

        threadPool.shutdown();
        threadPool.awaitTermination(5, TimeUnit.SECONDS);
    }
}
