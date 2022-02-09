/**
 * synchronized
 *
 * @author wyz
 */

package juc.c_001_sync_basics;

public class T02_SyncThis {

    private int count = 10;

    public void m() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

}

