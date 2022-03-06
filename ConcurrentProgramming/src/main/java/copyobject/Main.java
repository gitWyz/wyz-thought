package copyobject;

import java.io.IOException;

/**
 * @author wangyz
 * @date 2022/3/6
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        person.setName("w");
        person.setAge(18);
        Person clone = person.clone();
        Person person1 = person;
        Person person2 = (Person) person.deepClone();
        person.setAge(19);
        System.out.println(person);
        System.out.println(clone);
        System.out.println(person1);
        System.out.println(person2);
    }
}
