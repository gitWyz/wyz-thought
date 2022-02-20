package factorymethod;


import com.sun.org.apache.xml.internal.security.utils.ClassLoaderUtils;

import java.util.List;
import java.util.Random;

/**
 * @author wangyz
 * @date 2022/2/19
 */
public class HumanFactory {
    public static Human createHuman(Class c) {
        Human human = null;
        try {
            human = (Human) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return human;
    }
}
