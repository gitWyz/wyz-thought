package strategy;

/**
 * @author wangyz
 * @date 2022/2/19
 */
public class ZhaoYun {
    public static void main(String[] args) {
        Context context = new Context(new BackDoor());
        context.operate();
    }
}
