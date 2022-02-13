package juc.c_025;

import util.SleepHelperUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author yzw
 */
public class T08_SynchronusQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        SleepHelperUtil.sleepSeconds(2);
        strs.put("aaa");
        //strs.put("bbb");
        //strs.add("aaa");
        System.out.println(strs.size());
    }
}
