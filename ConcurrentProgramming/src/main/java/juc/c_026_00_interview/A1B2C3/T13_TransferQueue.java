package juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class T13_TransferQueue {
    public static void main(String[] args) throws InterruptedException {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        TransferQueue<Character> queue = new LinkedTransferQueue<Character>();
        Thread t1 = new Thread(() -> {
            try {
                for (char c : aI) {
                    //System.out.print(queue.take());
                    queue.transfer(c);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                for (char c : aC) {
                    queue.transfer(c);
                    //System.out.print(queue.take());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        t2.start();
        System.out.println(queue);
    }
}
