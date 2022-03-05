package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @apiNote 合并两个数组去重并排序
 * @author wangyz
 * @date 2022/2/28
 */
public class MergeArraySort {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,2,3,4,5,5,6,7,7};
        int[] result = MergeArraySort.mergeSort(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    /**
     * javadoc 合并两个数组去重并排序
     * @apiNote 方法中未进行数组1、数组2非空判断，所以传入的数组1、数组2 都不能为null,否则有一个为null会NPE
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return int[]
     * @date 2022-02-28 17:24:36
     * @author wangyz
     */
    public static int[] mergeSort(int[] arr1,int[] arr2) {
        // 创建辅助集合，其实数组创建新的数组也行，new int[arr1.length + arr2.length]
        List<Integer> list = new ArrayList<>();
        int index = 0; 
        int idx1 = 0;
        int idx2 = 0;
        // 先将arr1或者arr2中的首个元素添加到list
        // 这里其实得判断是否为null。
        list.add(arr1[idx1++]);
        // 当没有遍历完A和B中任意一个数组时执行
        while ( idx1 < arr1.length && idx2 < arr2.length ) {
            // 拿到当前索引的最小值
            int tmp = arr1[idx1] < arr2[idx2] ? arr1[idx1++] : arr2[idx2++];
            // 判断list中是否已经添加了此元素
            if (tmp > list.get(index)) {
                list.add(tmp);
                // 每次添加元素后索引后移
                index++;
            }
        }
        // 当arr2中元素添加完，只剩arr1中元素时
        while ( idx1 < arr1.length ) {
            int tmp = arr1[idx1++];
            if (tmp > list.get(index)) {
                list.add(tmp);
                index++;
            }
        }
        // 当arr1中元素添加完，只剩arr2中元素时
        while ( idx2 < arr2.length ) {
            int tmp = arr2[idx2++];
            if (tmp > list.get(index)) {
                list.add(tmp);
                index++;
            }
        }
        // 将list中元素重新移回到数组，如果刚开始创建的是数组，那么就不用这一步了
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
