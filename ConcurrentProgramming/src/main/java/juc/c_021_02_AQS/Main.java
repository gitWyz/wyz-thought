package juc.c_021_02_AQS;

import java.util.concurrent.locks.Lock;

/**
 * @author yzw
 */
public class Main {
    public static int m = 0;
    public static Lock lock = new MLock();

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                lock.lock();
                try {
                    for (int j = 0; j < 100; j++) {
                        m++;
                    }
                } finally {
                    lock.unlock();
                }
            });
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println(m);
    }
}