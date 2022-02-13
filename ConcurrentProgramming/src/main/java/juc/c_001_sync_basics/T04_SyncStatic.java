package juc.c_001_sync_basics;

/**
 * synchronized
 *
 * @author wyz
 */
public class T04_SyncStatic {

    private static int count = 10;

    //等同于synchronized(XX.class)
    public synchronized static void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void mm() {
        //考虑一下这里写synchornized(this)是否可以？
        synchronized (T04_SyncStatic.class) {
            count--;
        }
    }

    //m方法执行的时刻，n方法能不能同时执行？
    public synchronized void n() {

    }

}
