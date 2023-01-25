package dp;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        // TC : n * (m + n)
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < heights.length; j++) {
                if(matrix[i][j] != '0')
                    heights[j]++;
                else
                    heights[j] = 0;
            }
            maxArea = Math.max(maxArea, maxRectangleArea(heights));
        }
        return maxArea;
    }

    private int maxRectangleArea(int[] heights) {
        int[] prevMin = getPrevMin(heights);
        int[] nextMin = getNextMin(heights);
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++) {
            int l = heights[i];
            if(nextMin[i] == -1)
                nextMin[i] = heights.length;
            int b = nextMin[i] - prevMin[i] - 1;
            maxArea = Math.max(maxArea, (l * b));
        }
        return maxArea;
    }

    private int[] getPrevMin(int[] heights) {
        int[] prevMin = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < heights.length; i++) {
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                stack.pop();
            prevMin[i] = stack.peek();
            stack.push(i);
        }
        return prevMin;
    }

    private int[] getNextMin(int[] heights) {
        int[] nextMin = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = heights.length - 1; i >= 0; i--) {
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                stack.pop();
            nextMin[i] = stack.peek();
            stack.push(i);
        }
        return nextMin;
    }
}
