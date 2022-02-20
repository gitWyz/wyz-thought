package factorymethod;

/**
 * @author wangyz
 * @date 2022/2/19
 */
public class WhiteHuman implements Human{
    @Override
    public void laugh() {
        System.out.println("白色人笑");
    }

    @Override
    public void cry() {
        System.out.println("白色人哭");
    }

    @Override
    public void talk() {
        System.out.println("白色人说");
    }
}
