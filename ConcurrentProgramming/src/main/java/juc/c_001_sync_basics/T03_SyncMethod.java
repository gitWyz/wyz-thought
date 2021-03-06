package juc.c_001_sync_basics;

/**
 * synchronized关键字，对某个对象加锁
 *
 * @author wyz
 */
public class T03_SyncMethod {

    private int count = 10;

    public synchronized void m() { //synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }


}
