package juc.c_022_RefTypeAndThreadLocal;

/**
 * @author yzw
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
