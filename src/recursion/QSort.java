package recursion;

import java.util.Arrays;

public class QSort {
    public static void main(String[] args) {
//        int[] arr = {9, 4, 11, 3, 6, 45, 6, 6, 84, 33};
        int[] arr = {6, 6, 5};
        quickSort(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(e -> System.out.print(e +" "));
    }

    private static void quickSort(int[] arr, int s, int e) {
        if(e - s <= 1)
            return;

        int pivotIndex = partition(arr, s, e);

        // Sort left part
        quickSort(arr, s, pivotIndex - 1);
        // Sort right part
        quickSort(arr, pivotIndex + 1, e);
    }

    private static int partition(int[] arr, int s, int e) {
        int pivotElm = arr[s];
        int count = 0;

        for(int i = s + 1; i <= e; i++) {
            if(arr[i] < pivotElm)
                ++count;
        }

        int pivotIndex = s + count;
        swap(arr, s, pivotIndex);

        int i = s;
        int j = e;
        while(i < pivotIndex && j > pivotIndex) {
            if(arr[i] < arr[pivotIndex])
                ++i;
            if(arr[j] >= arr[pivotIndex]) // must remember
                --j;

            if(i < pivotIndex && j > pivotIndex) {
                swap(arr, i++, j--);
            }
        }
        return pivotIndex;
    }

    private static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}
