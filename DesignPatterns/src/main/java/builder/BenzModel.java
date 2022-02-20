package builder;

/**
 * @author wangyz
 * @date 2022/2/20
 */
public class BenzModel extends CarModel {

    @Override
    protected void start() {
        System.out.println("奔驰启动");
    }

    @Override
    protected void stop() {
        System.out.println("奔驰停止");
    }

    @Override
    protected void alarm() {
        System.out.println("奔驰鸣喇叭");
    }

    @Override
    protected void engineBoom() {
        System.out.println("奔驰引擎");
    }
}
