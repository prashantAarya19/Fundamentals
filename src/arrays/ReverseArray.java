package arrays;

import java.util.Arrays;

/*
{4, 10, 1, 3, 5}
{5, 3, 1, 10, 4}
 */
public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3, 5};
        printArray(arr);
        int[] temp = reverseArrayViaTempArray(arr);
        printArray(temp);
    }

    // Two pinter approach
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < arr.length/2) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            ++start;
            --end;
        }

    }

    public static int[] reverseArrayViaTempArray(int[] arr) {
        int[] temp = new int[arr.length];
        int start = 0;
        int i = arr.length - 1;

        while(i >= 0) {
            temp[start] = arr[i];
            --i;
            ++start;
        }

        return temp;
    }

    public static void printArray(int[] arr) {
        Arrays.stream(arr)
                .forEach(elm -> System.out.print(elm +" "));

        System.out.println();
    }
}
