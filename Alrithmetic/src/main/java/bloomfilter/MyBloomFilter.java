package bloomfilter;

import java.util.BitSet;

/**
 * @author wangyz
 * @date 2022/3/6
 */
public class MyBloomFilter {
    public static final int DEFAULT_SIZE = 1 << 25;

    /**
     * hash函数的种子
     */
    private static final int[] SEEDS = new int[]{3, 13, 46};

    /**
     * 位数组，数组中的元素只能是0或者1
     */
    private final BitSet bits = new BitSet(DEFAULT_SIZE);

    /**
     * hash函数
     */
    private final SimpleHash[] func = new SimpleHash[SEEDS.length];

    public MyBloomFilter() {
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    /**
     * 添加元素到位数组
     * @param value
     */
    public void add(Object value) {
        for (SimpleHash hash : func) {
            bits.set(hash.hash(value), true);
        }
    }

    public boolean contains(Object value) {
        boolean ret = true;
        for (SimpleHash hash : func) {
            ret = ret && bits.get(hash.hash(value));
            // hash函数有一个计算为false，则直接返回。
            if (!ret) {
                return ret;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Integer value1 = 13423;
        Integer value2 = 22131;
        MyBloomFilter filter = new MyBloomFilter();
        // false
        System.out.println(filter.contains(value1));
        // false
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        // true
        System.out.println(filter.contains(value1));
        // true
        System.out.println(filter.contains(value2));
    }

    /**
     * hash函数类
     */
    static class SimpleHash {
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(Object value) {
            int h = value.hashCode();
            return value == null ? 0 : Math.abs(seed * (cap - 1) & h ^ (h >>> 16));
        }
    }
}
