package sort;

import utils.PrintUtil;

/**
 * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
 * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 *
 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 * （1）从第一个元素开始，该元素可以认为已经被排序；
 * （2）取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * （3）如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * （4）重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * （5）将新元素插入到该位置后；
 * （6）重复步骤2~5。
 *
 * @author yzw
 */
public class InsertionSort {

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    public static int[] insertionSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int cur = i;
            while (cur>0 && arr[cur] < arr[cur-1]) {
                int temp = arr[cur];
                arr[cur] = arr[cur-1];
                arr[cur-1] = temp;
                cur--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        PrintUtil.print(insertionSort2(new int[]{5, 8, 2, 1, 9}));
    }
}
