package builder;

import java.util.ArrayList;

/**
 * @author wangyz
 * @date 2022/2/20
 */
public class BMWBuilder extends CarBuilder{
    BMWModel bmwModel = new BMWModel();
    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.bmwModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return bmwModel;
    }
}
