package singleton;

/**
 * 懒汉式(线程安全，同步方法)[不推荐用]
 *
 * @author wangyz
 * @date 2022/2/19
 */
public class Singleton4 {
    private static Singleton4 SINGLETON4;
    private Singleton4() {}
    public static synchronized Singleton4 newInstance() {
        if (SINGLETON4 == null) {
            SINGLETON4 = new Singleton4();
        }
        return SINGLETON4;
    }
}
