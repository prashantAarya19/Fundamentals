package revision;

import util.Utility;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {9, 9, 1, 2, 9, 6, 5, 4};
        sort(arr);
        Utility.printArray(arr);
    }

    public static void sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j])
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
