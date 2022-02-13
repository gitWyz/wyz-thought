package juc.c_022_RefTypeAndThreadLocal;

import util.SleepHelperUtil;

/**
 * @author yzw
 */
public class ThreadLocal1 {
    static Person p = new Person();

    public static void main(String[] args) {

        new Thread(() -> {
            SleepHelperUtil.sleepSeconds(1);
            p.name = "lisi";
        }).start();

        new Thread(() -> {
            SleepHelperUtil.sleepSeconds(2);
            System.out.println(p.name);
        }).start();

    }
}

class Person {
    String name = "zhangsan";
}
