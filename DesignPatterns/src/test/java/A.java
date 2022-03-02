/**
 * @author wangyz
 * @date 2022/2/27
 */
public class A {
    public static final int K = 10;

    public static final A a = new A();

    public A() {
        System.out.println("构造器A");
    }
    static {
        System.out.println("静态代码块");
    }
    public static void b() {
        System.out.println("方法b");
    }
    public static void main(String[] args) {

    }
}
