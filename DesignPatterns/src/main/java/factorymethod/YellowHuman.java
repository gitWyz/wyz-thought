package factorymethod;

/**
 * @author wangyz
 * @date 2022/2/19
 */
public class YellowHuman implements Human{
    @Override
    public void laugh() {
        System.out.println("黄色人笑");
    }

    @Override
    public void cry() {
        System.out.println("黄色人哭");
    }

    @Override
    public void talk() {
        System.out.println("黄色人说");
    }
}
