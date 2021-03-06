/**
 * synchronized关键字
 * 对某个对象加锁
 *
 * @author wyz
 */

package juc.c_001_sync_basics;

public class T01_SyncObject {

    private int count = 10;
    private final Object o = new Object();

    public void m() {
        //任何线程要执行下面的代码，必须先锁定o
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

}

