package singleton;

/**
 * 饿汉式（静态代码块）[可用]
 * 优缺点和方法一一样
 *
 * @author wangyz
 * @date 2022/2/19
 */
public class Singleton2 {
    private static final Singleton2 SINGLETON2;
    static {
        SINGLETON2 = new Singleton2();
    }
    private Singleton2() {}
    public static Singleton2 newInstance() {
        return SINGLETON2;
    }
}
