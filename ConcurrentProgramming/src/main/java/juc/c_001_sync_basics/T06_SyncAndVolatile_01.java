package juc.c_001_sync_basics;

/**
 * 分析一下这个程序的输出
 *
 * @author wyz
 */
public class T06_SyncAndVolatile_01 implements Runnable {

    private /*volatile*/ int count = 100;

    @Override
    public /*synchronized*/ void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        T06_SyncAndVolatile_01 t = new T06_SyncAndVolatile_01();
        for (int i = 0; i < 100; i++) {
            new Thread(t, "THREAD" + i).start();
        }
    }

}
