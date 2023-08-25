package revision;

import util.Utility;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9, 9, 1, 10, 9, 6, 5, 4, 1, 2, 3};
        sort(arr, 0, arr.length - 1);
        Utility.printArray(arr);
    }

    private static void sort(int[] arr, int s, int e) {
        if(e - s < 1)
            return;

        int pivotIndex = findPivot(arr, s, e);
        sort(arr, s, pivotIndex - 1);
        sort(arr, pivotIndex + 1, e);
    }

    private static int findPivot(int[] arr, int s, int e) {
        // 1. find the correct position for the element at start
        // 2. put it at the correct position
        // 3. arrange the smaller element on the left side of the array and larger element on the right side  of the array
        int pivotIndex = s;
        int pivotElem = arr[s];

        for(int i = s + 1; i <= e; i++) {
            if(arr[i] <= pivotElem)
                pivotIndex++;
        }

        swap(arr, s, pivotIndex);
        int start = s, end = e;

        while(start < pivotIndex && end > pivotIndex) {
            while(arr[start] <= pivotElem)
                start++;

            while(arr[end] > pivotElem)
                end--;

            if(start < pivotIndex && end > pivotIndex)
                swap(arr, start++, end--);
        }
        return pivotIndex;
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
/*
9, 9, 1, 2, 9, 6, 5, 4
9 -> 5
6, 9, 1, 2, 9, 9_, 5, 4
6, 4, 1, 2, 9, 9_, 5, 9
6, 4, 1, 2, 5, 9_, 9, 9
6, 4, 1, 2, 5
5, 4, 1, 2, 6

 */