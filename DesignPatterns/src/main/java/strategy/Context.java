package strategy;

/**
 * @author wangyz
 * @date 2022/2/19
 */
public class Context {
    private IStrategy strategy;
    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }
    public void operate() {
        strategy.operate();
    }
}
