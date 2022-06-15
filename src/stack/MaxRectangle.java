package stack;

import java.util.Stack;

public class MaxRectangle {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}};
        int n = 4;
        int m = 4;
       // Arrays.stream(first).forEach(e -> System.out.print(e + " "));
        int area = geMaxRectangleArea(arr, n, m);
        System.out.println(area);
    }

    private static int geMaxRectangleArea(int[][] arr, int n, int m) {
        int area = findMaxArea(arr[0]);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] != 0)
                    arr[i][j] = arr[i][j] + arr[i-1][j];
                else
                    arr[i][j] = 0;
            }
            int currentArea = findMaxArea(arr[i]);
            area = Integer.max(area, currentArea);
        }
        return area;
    }

    private static int[] prevSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            while (stack.peek() != -1 && arr[stack.peek()] >= arr[i])
                stack.pop();
            result[i] = stack.peek();
            stack.push(i);
        }
        return result;
    }

    private static int[] nextSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] result = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            while (stack.peek() != -1 && arr[stack.peek()] >= arr[i])
                stack.pop();
            result[i] = stack.peek();
            stack.push(i);
        }
        return result;
    }

    private static int findMaxArea(int[] arr) {
        int[] prevSmaller = prevSmaller(arr);
        int[] nextSmaller = nextSmaller(arr);
        int area = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            int l = arr[i];
            if(nextSmaller[i] == -1)
                nextSmaller[i] = arr.length;
            int w = nextSmaller[i] - prevSmaller[i] - 1;
            int currentArea = l*w;
            area = Integer.max(area, currentArea);
        }
        return area;
    }

}
