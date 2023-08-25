package recursion.practice;

import java.util.Arrays;

public class QSort {
    public static void main(String[] args) {
//        int[] arr = {3, 4, 2, 54, 23, 1, 99, 22};
//        int[] arr = {4, 1, 3, 9, 7};
        int[] arr = {9, 9, 1, 2, 9, 6, 5, 4};
        Arrays.stream(arr).forEach(e -> System.out.print(e +" "));
        System.out.println();
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(e -> System.out.print(e +" "));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(high - low < 1)
            return;

        int pivotIndex = findPivot(arr, low, high); // O(n)
        quickSort(arr, low, pivotIndex - 1); // O(logN)
        quickSort(arr, pivotIndex + 1, high); // O(logN)
    }

    private static int findPivot(int[] arr, int low, int high) {
        int pivotElm = arr[low];
        int count = 0;
        for(int i = low + 1; i <= high; i++) {
            if(arr[i] <= pivotElm)
                count++;
        }

        int pivotIndex = count + low;
        arr[low] = arr[pivotIndex];
        arr[pivotIndex] = pivotElm;

        int i = low;
        int j = high;
        while(i < pivotIndex && j > pivotIndex) {
            while(arr[i] <= pivotElm)
                i++;

            while (arr[j] > pivotElm && j > pivotIndex)
                j--;

            if(i < pivotIndex && j > pivotIndex) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
                i++;
            }
        }

        return pivotIndex;
    }


}
