package juc.c_000_threadbasic;

import util.SleepHelperUtil;

/**
 * interrupt sync
 * @author yzw
 */
public class T09_Interrupt_and_sync {

    private static Object o = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (o) {
                SleepHelperUtil.sleepSeconds(5);
                System.out.println("t1线程持有锁");
            }
        });

        t1.start();

        SleepHelperUtil.sleepSeconds(1);
        t1.interrupt();

        Thread t2 = new Thread(() -> {
            synchronized (o) {
                System.out.println("t2线程持有锁");
            }
            System.out.println("t2 end!");
        });

        t2.start();

        SleepHelperUtil.sleepSeconds(1);

        t2.interrupt();
    }
}
