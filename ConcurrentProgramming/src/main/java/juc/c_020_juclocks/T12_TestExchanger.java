package juc.c_020_juclocks;

import java.util.concurrent.Exchanger;

/**
 *  Exchanger的功能可以使2个线程之间传输数据,它比生产者消费者模式使用的wait/notify要更加方便,
 *  类Exchanger中的exchange()方法具有阻塞的特色,也就是此方法被调用后等待其他线程来取得数据，
 *  如果没有其他线程取得数据，则一直阻塞等待。
 *  Exchanger主要有两个方法 :exchanger(V x)、exchanger(V x, long timeout, TimeUnit unit)。
 * @author yzw
 */
public class T12_TestExchanger {

    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(() -> {
            String s = "T1";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t1").start();


        new Thread(() -> {
            String s = "T2";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t2").start();


    }
}
