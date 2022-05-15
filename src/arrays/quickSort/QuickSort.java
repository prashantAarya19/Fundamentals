package arrays.quickSort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9, 4, 11, 3, 6, 45, 6, 6, 84, 33};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }

    private static void quickSort(int[] arr, int s, int e) {
        if (e - s <= 1) {
            return;
        }

        int pivot = partition(arr, s, e);

        // sort left side of array
        quickSort(arr, s, pivot - 1);
        quickSort(arr, pivot + 1, e);
    }

    private static int partition(int[] arr, int s, int e) {
        int pivotElm = arr[s];
        int count = 0;
        for (int i = s + 1; i <= e; i++) {
            if (arr[i] < pivotElm) {
                ++count;
            }
        }

        int pivotIndex = s + count;

        // swap
        arr[s] = arr[pivotIndex];
        arr[pivotIndex] = pivotElm;

        int i = s;
        int j = e;

        while (i < pivotIndex && j > pivotIndex) {
            while (arr[i] < arr[pivotIndex]) {
                ++i;
            }

            while (arr[j] >= arr[pivotIndex]) {
                --j;
            }

            if (i < pivotIndex && j > pivotIndex) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                --j;
                ++i;
            }
        }
        return pivotIndex;
    }
}
