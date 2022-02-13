package example;

import util.SleepHelperUtil;

import java.util.concurrent.locks.LockSupport;

/**
 * @author wangyz
 * @date 2022/2/13
 */
public class LockSupportParkAndUnpark {

    static Object o = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SleepHelperUtil.sleepSeconds(5);
                synchronized (o) {
                    System.out.println("threadName "+ Thread.currentThread().getName() + "start");
                    LockSupport.park();
                    SleepHelperUtil.sleepSeconds(5);
                    System.out.println("threadName "+ Thread.currentThread().getName() + " end");
                }
            }
        });
        t1.setName("t1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                LockSupport.unpark(t1);
                synchronized (o) {
                    System.out.println("threadName " + Thread.currentThread().getName() + " start");
                }
            }
        });
        t2.setName("t2");
        t2.start();

    }
}
