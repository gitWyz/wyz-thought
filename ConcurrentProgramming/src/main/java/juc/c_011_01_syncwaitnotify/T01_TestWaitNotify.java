package juc.c_011_01_syncwaitnotify;

import util.SleepHelperUtil;

/**
 * @author yzw
 */
public class T01_TestWaitNotify {
    private static Object o = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (o) {
                System.out.println("starting ...");
                SleepHelperUtil.sleepSeconds(1);
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end!");
            }
        }).start();


        SleepHelperUtil.sleepSeconds(5);

        synchronized (o) {
            //o.notify();
            o.notifyAll();
        }

    }
}
