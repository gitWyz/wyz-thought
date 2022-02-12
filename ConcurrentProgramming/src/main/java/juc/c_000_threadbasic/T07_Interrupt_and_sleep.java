package juc.c_000_threadbasic;

import util.SleepHelperUtil;

/**
 * interrupt与sleep()
 * @author yzw
 */
public class T07_Interrupt_and_sleep {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("线程sleep结束");
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted!");
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });

        t.start();

        SleepHelperUtil.sleepSeconds(1);

        t.interrupt();
    }
}
