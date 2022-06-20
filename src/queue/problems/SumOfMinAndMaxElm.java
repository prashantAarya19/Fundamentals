package queue.problems;

import java.util.ArrayDeque;

public class SumOfMinAndMaxElm {
    public static void main(String[] args) {
        int[] arr = {2, 5, -1, 7, -3, -1, -2};
        int k = 4;
        int result = findSum(arr, k);
        System.out.println(result);
    }

    private static int findSum(int[] arr, int k) {
        ArrayDeque<Integer> min = new ArrayDeque<>();
        ArrayDeque<Integer> max = new ArrayDeque<>();
        int sum = 0;

        // process first k element
        for(int i = 0; i < k; i++) {
            // removing the element lesser than arr[i] in q
            while(!max.isEmpty() && arr[max.peek()] < arr[i])
                max.remove();
            // removing the element greater than arr[i] in q
            while(!min.isEmpty() && arr[min.peek()] > arr[i])
                min.remove();
            // adding the index in min and max q
            min.add(i);
            max.add(i);
        }

        // add elements into sum
        if(!min.isEmpty())
            sum += arr[min.peek()];
        if(!max.isEmpty())
            sum += arr[max.peek()];

        // for rest elements
        for(int i = k; i < arr.length; i++) {
           // removing the element which are not in window of max
           while (!max.isEmpty() && i - max.peek() >= k)
               max.removeFirst();
           // removing the element which are not in window of min
           while(!min.isEmpty() && i - min.peek() >= k)
               min.removeFirst();
           max.add(i);
           min.add(i);

            while(!max.isEmpty() && arr[max.peek()] < arr[i])
                max.remove();
            while(!min.isEmpty() && arr[min.peek()] > arr[i])
                min.remove();
            if(!min.isEmpty())
                sum += arr[min.peek()];
            if(!max.isEmpty())
                sum += arr[max.peek()];
        }
        return sum;
    }
}
