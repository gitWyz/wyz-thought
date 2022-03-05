package sort;

import utils.PrintUtil;

/**
 * 冒泡排序
 * 算法描述
 * 1、比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 3、针对所有的元素重复以上的步骤，除了最后一个；
 * 4、重复步骤1~3，直到排序完成。
 *
 * @author yzw
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length - i - 1; j++) {
                if (ints[j] > ints[j+1]) {
                    int temp = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = temp;
                }
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = {4, 3, 9, 1, 7};
        PrintUtil.print(bubbleSort(ints));
    }
}
