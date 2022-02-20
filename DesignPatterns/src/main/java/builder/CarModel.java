package builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyz
 * @date 2022/2/20
 */
public abstract class CarModel {
    private List<String> seq = new ArrayList<>();
    protected abstract void start();
    protected abstract void stop();
    protected abstract void alarm();
    protected abstract void engineBoom();
    public final void run() {
        //循环一遍，谁在前，就先执行谁
        for (String actionName : seq) {
            if (actionName.equalsIgnoreCase("start")) {
                start();
            } else if (actionName.equalsIgnoreCase("stop")) {
                stop();
            } else if (actionName.equalsIgnoreCase("alarm")) {
                alarm();
            } else if (actionName.equalsIgnoreCase("engine boom")) {
                engineBoom();
            }
        }
    }
    /**
     * 把传递过来的值传递到类内
     */
    public final  void setSequence(List<String> sequence){
        this.seq = sequence;
    }
}
