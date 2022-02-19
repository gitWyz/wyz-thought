package proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类(这里可以理解为律师对象)
 * @author wangyz
 * @date 2022/2/19
 */
public class DynamicProxy implements InvocationHandler {

    /**
     * 代理者的引用（这里可以理解为 X 程序员）
     */
    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过反射调用其代理者的方法
        return method.invoke(object, args);
    }
}
