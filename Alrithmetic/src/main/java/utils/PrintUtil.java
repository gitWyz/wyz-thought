package utils;

public class PrintUtil {
    public static void print(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(arr[i]);
            if (i < length - 1) {
                stringBuilder.append(", ");
            }
        }
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
        print(new int[]{7, 4, 9});
    }
}
