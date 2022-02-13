package juc.c_020_juclocks;

import util.SleepHelperUtil;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁，读锁其他线程可以共用，写锁其他其他线程不能共用
 * @author yzw
 */
public class T10_TestReadWriteLock {
    static Lock lock = new ReentrantLock();
    private static int value;

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock) {
        readLock.lock();
        try {
            SleepHelperUtil.sleepSeconds(1);
            System.out.println(Thread.currentThread().getName() + "read over!");
            //模拟读取操作
        } finally {
            readLock.unlock();
        }
    }

    public static void write(Lock lock, int v) {
        writeLock.lock();
        try {
            SleepHelperUtil.sleepSeconds(1);
            value = v;
            System.out.println(Thread.currentThread().getName() + "write over!");
            //模拟写操作
        } finally {
            writeLock.unlock();
        }
    }


    public static void main(String[] args) {
        Runnable readR = () -> read(lock);
        Runnable readR2 = () -> read(lock);
        //Runnable readR = ()-> read(readLock);

        Runnable writeR = () -> write(lock, new Random().nextInt());
        //Runnable writeR = ()->write(writeLock, new Random().nextInt());

        for (int i = 0; i < 5; i++) {
            Thread tR1 = new Thread(readR);
            Thread tR2 = new Thread(readR2);
            tR1.setName("tR1");
            tR2.setName("tR2");
            tR1.start();
            tR2.start();
        }
        for (int i = 0; i < 5; i++) {
            Thread tW1 = new Thread(writeR);
            Thread tW2 = new Thread(writeR);
            tW1.setName("tR1");
            tW2.setName("tR2");
            tW1.start();
            tW2.start();
        }


    }
}
