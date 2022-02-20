package builder;

import java.util.ArrayList;

/**
 * @author wangyz
 * @date 2022/2/20
 */
public class BenzBuilder extends CarBuilder{
    BenzModel benzModel = new BenzModel();
    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.benzModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return benzModel;
    }
}
