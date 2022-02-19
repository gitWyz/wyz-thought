package strategy;

/**
 * @author wangyz
 * @date 2022/2/19
 */
public class GivenGreenLight implements IStrategy{

    @Override
    public void operate() {
        System.out.println("开绿灯");
    }
}
