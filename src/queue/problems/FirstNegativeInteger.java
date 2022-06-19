package queue.problems;

import java.util.ArrayDeque;
import java.util.Arrays;

public class FirstNegativeInteger {
    public static long[] printFirstNegativeInteger(long[] arr, int n, int k) {
        long[] result = new long[2*k];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int counter = 0;
        // For first window
        for(int i = 0; i < k; i++) {
            if(arr[i] < 0) {
                queue.add(i);
            }
        }

        if(!queue.isEmpty() && arr[queue.peek()] < 0) {
           result[counter++] = arr[queue.peek()];
        } else
            result[counter++] = 0;

        // For remaining window
        for(int i = k; i < arr.length; i++) {
            if(!queue.isEmpty() && i - queue.peek() >= k)
                queue.removeFirst();
            if(arr[i] < 0)
                queue.add(i);
            if(!queue.isEmpty() && arr[queue.peek()] < 0)
                    result[counter++] = arr[queue.peek()];
            else
                result[counter++] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
//        long[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
//        long[] arr = {-8, 2, 3, -6, 10};
        long[] arr = {-8, -5, -2, 1};
        long[] result = printFirstNegativeInteger(arr, 4, 2);
        Arrays.stream(result).forEach(e -> System.out.print(e +" "));
    }
}
