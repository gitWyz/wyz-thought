package juc.c_026_01_ThreadPool;

import java.util.concurrent.*;

public class T03_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("threadName:"+Thread.currentThread().getName());
        Callable<String> c = new Callable() {
            @Override
            public String call() {
                System.out.println("threadName:"+Thread.currentThread().getName());
                return "Hello Callable";
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(c);

        System.out.println(future.get());

        service.shutdown();
    }

}
