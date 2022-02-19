package strategy;

/**
 * @author wangyz
 * @date 2022/2/19
 */
public class BlockEnemy implements IStrategy {
    @Override
    public void operate() {
        System.out.println("阻击追兵");
    }
}
