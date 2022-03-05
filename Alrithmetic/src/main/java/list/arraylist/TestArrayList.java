package list.arraylist;

/**
 * @author wangyz
 * @version 1.0
 * @date 2021/4/5
 */
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(101);
        list.add(102);
        System.out.println(list.set(1, 90));
        System.out.println(list.toString());
    }
}
