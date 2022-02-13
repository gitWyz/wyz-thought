package juc.c_025;

import util.SleepHelperUtil;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @author yzw
 */
public class T09_TransferQueue {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();

        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        SleepHelperUtil.sleepSeconds(2);
        strs.transfer("aaa");

        //strs.put("aaa");


		/*new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();*/


    }
}
