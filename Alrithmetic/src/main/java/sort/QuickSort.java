package sort;

import utils.PrintUtil;

/**
 * @author wangyz
 * @date 2022/3/6
 */
public class QuickSort {
    public int[] sort(int[] arr) {
        return quickSort(arr, 0 , arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值(pivot)
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index-1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 10, 2, 4, 9, 7, 1, 5, 8};
        QuickSort quickSort = new QuickSort();
        int[] sort = quickSort.sort(arr);
        PrintUtil.print(sort);
    }
}
