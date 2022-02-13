package juc.c_001_00_thread_end;

import util.SleepHelperUtil;

/**
 * 使用volatile修饰的变量标识位结束线程
 * @author yzw
 */
public class T03_VolatileFlag {

    private static boolean running = true;

    private static void m() {
        System.out.println("threadName="+Thread.currentThread().getName());
        System.out.println("m start");
        int i = 0;
        while (running) {
            System.out.println("hello" + i++);
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        /*Thread t = new Thread(() -> {
            long i = 0L;
            while (running) {
                //wait recv accept
                i++;
            }

            System.out.println("end and i = " + i); //4168806262 4163032200
        });*/

        new Thread(T03_VolatileFlag::m).start();

        //SleepHelperUtil.sleepSeconds(1);

        running = false;
    }
}
