package juc.c_026_01_ThreadPool;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallableTask implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("callable do something");
        Thread.sleep(5000);
        System.out.println("threadName:"+Thread.currentThread().getName());
        return new Random().nextInt(100);
    }

    public static void main(String[] args) throws Exception {
        MyCallableTask myCallableTask = new MyCallableTask();
        myCallableTask.call();
        System.out.println("threadName:"+Thread.currentThread().getName());
    }
}
