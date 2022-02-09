/**
 * 弱引用遭到gc就会回收
 */
package juc.c_022_RefTypeAndThreadLocal;

import util.SleepHelperUtil;

import java.lang.ref.WeakReference;

public class T03_WeakReference {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());

        System.out.println(m.get());
        System.gc();
        SleepHelperUtil.sleepSeconds(1);
        System.out.println(m.get());


        /*ThreadLocal<M> tl = new ThreadLocal<>();
        tl.set(new M());
        tl.remove();*/

    }
}

