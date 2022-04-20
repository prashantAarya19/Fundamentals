package arrays.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {25, 2, 10 , 9, 3, 4, 6, 8, 15};
        Arrays.stream(arr).forEach(e -> System.out.print(e +" "));
        System.out.println();
        sortArray(arr);
        Arrays.stream(arr).forEach(e -> System.out.print(e +" "));
    }
    /** worst complexity O(n^2) **/
    public static void sortArray(int[] arr) {

        for(int i = 0; i < arr.length; i++) { // first is just used iterating through the array
            for(int j = 0; j < arr.length-1; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
