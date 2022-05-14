package recursion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,6, 2, 1, 11, 10};
        bubbleSort(arr, arr.length - 1);
        Arrays.stream(arr).forEach(e -> System.out.print(e +" "));
    }

    private static void bubbleSort(int[] arr, int n) {
        if(n == 1 || n == 0)
            return;

        for(int i = 0; i < n; i++) {
            if(arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        bubbleSort(arr, n - 1);

    }


}
