package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraySum {

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(sum2(arr, arr.length));
    }

    private static int sum(int[] arr, int s, int sum) {
        if(arr.length == 1)
            return arr[0];

        if(s == arr.length)
            return sum;

        sum += arr[s++];
        return sum(arr, s, sum);
    }

    private static int sum2(int[] arr, int n) {

        if(n <= 0)
            return 0;

        return sum2(arr, n - 1) + arr[n - 1];
    }
}
