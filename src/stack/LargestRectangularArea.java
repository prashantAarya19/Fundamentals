package stack;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LargestRectangularArea {
    public static void main(String[] args) {
//        int[] arr = {2,1,5,6,2,3};
        int[] arr = {2,4};
//        int area = findLargestArea(arr);
//        System.out.println(area);
        AtomicInteger b = new AtomicInteger(3);
        ArrayList<Integer> all = new ArrayList<>();
        int c = 4;
        Supplier<Integer> s = () -> c;
        System.out.println(s.get());
    }

    private static int findLargestArea(int[] arr) {
        int[] previousSmallest = getPreviousSmallest(arr);
        int[] nextSmallest = getNextSmallest(arr);
        int area = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            int h = arr[i];
            if(nextSmallest[i] == -1)
                nextSmallest[i] = arr.length;
            int w = nextSmallest[i] - previousSmallest[i] - 1;
            int a = h * w;
            area = Integer.max(area, a);
        }
        return area;
    }

    private static int[] getNextSmallest(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] result = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            while(stack.peek() != -1 && arr[stack.peek()] >= arr[i])
                stack.pop();
            result[i] = stack.peek();
            stack.push(i);
        }
        return result;
    }

    private static int[] getPreviousSmallest(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            while(stack.peek() != -1 && arr[stack.peek()] >= arr[i])
                stack.pop();
            result[i] = stack.peek();
            stack.push(i);
        }
        return result;
    }


}
