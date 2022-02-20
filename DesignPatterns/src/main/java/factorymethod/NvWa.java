package factorymethod;

/**
 * @author wangyz
 * @date 2022/2/19
 */
public class NvWa {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Human human = HumanFactory.createHuman(WhiteHuman.class);

    }
}
