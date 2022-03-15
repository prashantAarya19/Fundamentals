package arrays;

import java.util.Arrays;

public class SwapAlternate {

    public static void swapArray(int[] arr) {
        int start = 0;

        while(start < arr.length-1) {
            int temp = arr[start];
            int next = start + 1;
            arr[start] = arr[next];
            arr[next] = temp;
            start = start+2;
        }
    }

    public static void printArray(int[] arr) {
        Arrays.stream(arr)
                .forEach(elm -> System.out.print(elm +" "));

        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3, 5, 6};

        printArray(arr);
        swapArray(arr);
        printArray(arr);
    }
}
