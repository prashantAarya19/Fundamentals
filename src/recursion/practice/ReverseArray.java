package recursion.practice;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
//        solve(array, 0, array.length - 1);
        solve(array, 0);
        System.out.println();
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
    }

    private static void solve(int[] array, int start, int end) {
        if(start == end)
            return;

        swap(array, start, end);
        solve(array, start + 1, end - 1);
    }

    private static void solve(int[] array, int start) {
        if(start == array.length / 2)
            return;

        swap(array, start, array.length - 1 - start);
        solve(array, start + 1);
    }



    private static void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}
