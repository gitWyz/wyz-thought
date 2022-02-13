package juc.c_024_FromVectorToQueue;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * @author yzw
 */
public class TicketSeller2 {
    static Vector<String> tickets = new Vector<>();


    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("ticket" + i);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (tickets.size() > 0) {

                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    System.out.println("--" + tickets.remove(0));
                }
            }).start();
        }
    }
}
