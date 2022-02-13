package juc.c_020_juclocks;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行。叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用。
 * 我们暂且把这个状态就叫做barrier，当调用await()方法之后，线程就处于barrier了。
 * 在初次的线程越过barrier状态后，又可以用来进行新一轮的使用。而CountDownLatch无法进行重复使用。
 * @author yzw
 */
public class T07_TestCyclicBarrier {
    static int count = 0;
    public static void main(String[] args) {

        //CyclicBarrier barrier = new CyclicBarrier(20);

        /**
         * 参数parties指让多少个线程或者任务等待至barrier状态；
         * 参数barrierAction为当这些线程都达到barrier状态时会执行的内容。
         */
        CyclicBarrier barrier = new CyclicBarrier(20, () -> System.out.println("满人"));

        /*CyclicBarrier barrier = new CyclicBarrier(20, new Runnable() {
            @Override
            public void run() {
                System.out.println("满人，发车");
            }
        });*/

        for (int i = 0; i < 100; i++) {

            new Thread(() -> {
                try {
                    barrier.await();
                    System.out.println("count = " + count++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
