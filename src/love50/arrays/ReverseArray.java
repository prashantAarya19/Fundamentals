package love50.arrays;

import static util.Utility.printArray;

public class ReverseArray {
    public static void reverseArray(int[] arr) {
        int s = 0;
        int e = arr.length - 1;

        while(s < e) {
            int temp = arr[s];
            arr[s++] = arr[e];
            arr[e--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        reverseArray(arr);
        printArray(arr);
    }
}
