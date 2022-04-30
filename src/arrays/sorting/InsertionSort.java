package arrays.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {25, 2, 10, 9, 3, 4, 6, 8, 15};
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        System.out.println();
        insertionSort(arr);
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }

    public static void sortArray(int[] arr) {
        // we are starting i = 1 as 1 element will always be sorted.
        // Hint: Arranging a card one by one.
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int maxElm = arr[i];
            while (j >= 0) {
                if (maxElm < arr[j]) arr[j + 1] = arr[j];
                else break;
                --j;
            }
            // By the time the flow will come here we would have got actual position of minElm
            arr[j + 1] = maxElm;
        }
    }

    // Practice copy of the above solution
    public static void insertionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int currentMin = arr[i];
            int j = i - 1;

            while(j >= 0) {
                if(currentMin < arr[j]) arr[j+1] = arr[j];
                else break;
                --j;
            }
            arr[j+1] = currentMin;
        }
    }


}
