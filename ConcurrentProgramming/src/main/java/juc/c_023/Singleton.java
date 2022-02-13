package juc.c_023;

import java.util.Arrays;

/**
 * 线程安全的单例模式
 * @author yzw
 */
public class Singleton {

    private Singleton() {
        System.out.println("single");
    }

    private static class Inner {
        private static Singleton s = new Singleton();
    }

    public static Singleton getSingle() {
        return Inner.s;
    }

    static void fun(){}

    public static void main(String[] args) {
        Singleton.fun();
        Singleton0.fun0();
//        Thread[] ths = new Thread[20];
//        for (int i = 0; i < ths.length; i++) {
//            ths[i] = new Thread(() -> {
//                System.out.println(Singleton.getSingle());
//            });
//        }
//
//        Arrays.asList(ths).forEach(o -> o.start());
    }

    static class Singleton0{
        private final static Singleton0 obj = new Singleton0();
        private Singleton0() {
            System.out.println("我被new出来了");//每生成一个实例就打印这句话，便于测试。
        }
        public static Singleton0 getInstance() {
            return obj;
        }
        public static void fun0(){

        }
    }

}
