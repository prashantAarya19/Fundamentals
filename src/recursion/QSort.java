package recursion;

import java.util.Arrays;

public class QSort {
    public static void main(String[] args) {
//        int[] arr = {9, 4, 11, 3, 6, 45, 6, 6, 84, 33};
        int[] arr = {9, 4, 11, 3, 6, 45, 84, 33, 33, 33, 10};
       // int[] arr = {6, 6, 8, 5, 8};
        quickSort(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(e -> System.out.print(e +" "));
    }

    private static void quickSort(int[] arr, int s, int e) {
        if(s >= e)
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
       for(int i = s; i <= e; i++) {
           if(arr[i] < pivotElm)
               ++count;
       }
       int pivIndex = s + count;
       swap(arr, s, pivIndex);
       int i = s;
       int j = e;
       while(i < pivIndex && j > pivIndex) {
           while(arr[i] < arr[pivIndex])
               ++i;

           while(arr[j] > arr[pivIndex])
               --j;

           if(i < pivIndex && j > pivIndex)
               swap(arr, i++, j--);
       }
       return pivIndex;
    }

    private static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}
