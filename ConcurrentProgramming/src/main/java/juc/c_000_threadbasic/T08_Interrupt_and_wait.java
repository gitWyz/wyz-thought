package juc.c_000_threadbasic;

import util.SleepHelperUtil;

/**
 * interrupt与wait()
 * @author yzw
 */
public class T08_Interrupt_and_wait {

    private static Object o = new Object();

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            synchronized (o) {
                try {
                    o.wait();
                    System.out.println("线程wait结束");
                } catch (InterruptedException e) {
                    System.out.println("Thread is interrupted!");
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });

        t.start();

        SleepHelperUtil.sleepSeconds(5);

        t.interrupt();
    }
}
