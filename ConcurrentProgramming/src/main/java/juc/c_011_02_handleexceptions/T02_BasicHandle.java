package juc.c_011_02_handleexceptions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程异常不会被另外一个线程捕获
 * @author yzw
 */
public class T02_BasicHandle {
    public static void main(String[] args) {
        Runnable r = () -> {
            throw new RuntimeException();
        };

        try {
            Executors.newCachedThreadPool().execute(r);
        } catch (RuntimeException e) {
            System.out.println("Exception!");
        }
    }
}
