package bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author wangyz
 * @date 2022/3/6
 */
public class GoogleBloomFilter {
    public static void main(String[] args) {
        // 创建布隆过滤器对象，最多元素数量为500，期望误报概率为0.01
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 500, 0.01);
        bloomFilter.put(1);
        System.out.println(bloomFilter.mightContain(1));
    }
}
