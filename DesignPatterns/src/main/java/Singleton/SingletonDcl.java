package Singleton;

/**
 * @author wangyz
 * @date 2022/2/10
 */
public class SingletonDcl {
    private static volatile SingletonDcl singletonDcl;
    private static SingletonDcl getInstance() {
        if (singletonDcl == null) {
            synchronized (SingletonDcl.class) {
                if (singletonDcl == null) {
                    return new SingletonDcl();
                }
            }
        }
        return singletonDcl;
    }
}
