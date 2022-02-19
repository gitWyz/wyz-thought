package proxy.dynamicproxy;

import proxy.staticproxy.ProxyLawyer;

import java.lang.reflect.Proxy;

/**
 * @author wangyz
 * @date 2022/2/19
 */
public class Main {

    public static void main(String[] args) {
        ILawsuit lawsuit = new XProgrammer();
        DynamicProxy dynamicProxy = new DynamicProxy(lawsuit);
        ClassLoader classLoader = lawsuit.getClass().getClassLoader();
        ILawsuit proxyLawyer = (ILawsuit) Proxy.newProxyInstance(classLoader, new Class[]{ILawsuit.class}, dynamicProxy);
        proxyLawyer.submit();
        proxyLawyer.burden();
        proxyLawyer.defend();
        proxyLawyer.finish();
    }
}
