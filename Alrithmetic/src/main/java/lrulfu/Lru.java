package lrulfu;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 最近最少使用
 * @author wangyz
 * @date 2022/3/5
 */
public class Lru<K, V> extends LinkedHashMap<K, V> {
    private final int MAX_SIZE;

    public Lru(int capcity) {
        super(8, 0.75f, true);
        this.MAX_SIZE = capcity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        if (size() > MAX_SIZE) {
            System.out.println("移除的元素为：" + eldest.getValue());
        }
        return size() > MAX_SIZE;
    }

    /**
     * javadoc main
     * @apiNote 为了测试，在加入元素4的时候，访问了一下元素1，然后看到，在缓存达到限制时，最先移除的不是1，而是2，3然后是1。
     *
     * @param args
     * @return void
     * @date 2022-03-05 17:07:20
     * @author wangyz
     */
    public static void main(String[] args) {
        Map<Integer, Integer> map = new Lru<>(5);
        for (int i = 0; i < 12; i++) {
            map.put(i, i);
            System.out.println("cache的容量为：" + map.size());
            if (i == 4) {
                map.get(1);
            }
        }
        System.out.println("==========================map的元素");
        map.entrySet().forEach(integerIntegerEntry -> System.out.print(integerIntegerEntry.getValue() + ",  "));
    }
}
