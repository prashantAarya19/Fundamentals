package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextSmallestElement {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3};
        int[] result = getPreviousSmallerElement(arr);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }

    private static int[] getNextSmallerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] result = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            while(stack.peek() >= arr[i])
                stack.pop();
            result[i] = stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }

    private static int[] getPreviousSmallerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] result = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            while(stack.peek() >= arr[i])
                stack.pop();
            result[i] = stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }


}
