package revision;

import util.Utility;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 9, 9, 6, 5, 4};
        sort(arr);
        Utility.printArray(arr);
    }

    private static void sort(int[] arr) {

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j + 1] < arr[j])
                    swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
