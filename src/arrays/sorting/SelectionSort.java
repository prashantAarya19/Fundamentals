package arrays.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {10 , 9, 3, 4, 6, 8};
        Arrays.stream(arr).forEach(e -> System.out.print(e +" "));
        System.out.println();
        sortArray(arr);
        Arrays.stream(arr).forEach(e -> System.out.print(e +" "));
    }

    /**Worst complexity = O(n^2)**/
    public static void sortArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) swap(arr, i, j);
            }
        }
    }

    public static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}
