package factorymethod;

/**
 * @author wangyz
 * @date 2022/2/19
 */
public class BlackHuman implements Human{
    @Override
    public void laugh() {
        System.out.println("黑色人笑");
    }

    @Override
    public void cry() {
        System.out.println("黑色人哭");
    }

    @Override
    public void talk() {
        System.out.println("黑色人说");
    }
}
