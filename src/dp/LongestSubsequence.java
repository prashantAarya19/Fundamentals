package dp;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestSubsequence {
    static int longestSubsequence(int size, int[] a)
    {
        int current = 0;
        int previous = -1;
//        int[][] dp = new int[size][size + 1];
//        Arrays.stream(dp).forEach(e -> Arrays.fill(e, -1));
        return solveRecursively(size, a, current, previous);
    }

    private static int solveRecursively(int size, int[] a, int current, int previous) {
        if(current == size)
            return 0;

        int include = 0;
        if(previous == -1 || a[current] > a[previous])
            include = 1 + solveRecursively(size, a, current + 1, current);

        int exclude = solveRecursively(size, a, current + 1, previous);

        return Integer.max(include, exclude);
    }

    private static int solveTab(int size, int[] a, int current, int previous, int[][] dp) {
        if(current == size)
            return 0;

        if(dp[current][previous + 1] != -1)
            return dp[current][previous + 1];

        int include = 0;
        if(previous == -1 || a[current] > a[previous])
            include = 1 + solveTab(size, a, current + 1, current, dp);

        int exclude = solveTab(size, a, current + 1, previous, dp);

        dp[current][previous + 1] = Integer.max(include, exclude);
        return dp[current][previous + 1];
    }

    private static int solveTab(int size, int[] a) {
        int[][] dp = new int[size + 1][size + 1];

        for(int current = size - 1; current >= 0; current--) {
            for(int previous = current - 1; previous >= -1; previous--) {
                int include = 0;
                if(previous == -1 || a[current] > a[previous])
                    include = 1 + dp[current + 1][current + 1];

                int exclude = dp[current + 1][previous + 1];

                dp[current][previous + 1] = Integer.max(include, exclude);
            }
        }


        return dp[0][0];
    }

    private static int solveTab2(int size, int[] a) {
        int[] prev = new int[size + 1];

        for(int current = size - 1; current >= 0; current--) {
            int[] next = new int[size + 1];
            for(int previous = current - 1; previous >= -1; previous--) {
                int include = 0;
                if(previous == -1 || a[current] > a[previous])
                    include = 1 + prev[current + 1];

                int exclude = prev[previous + 1];

                next[previous + 1] = Integer.max(include, exclude);
            }
            prev = next;
        }


        return prev[0];
    }

    private static int solveOptimized(int size, int[] a) {
        if(size == 0)
            return 0;

        int[] result = new int[size];
        Arrays.fill(result, -1);
        result[0] = a[0];
        int j = 1;
        for(int i = 1; i < size; i++) {
            if(a[i] > result[j - 1]) {
                result[j++] = a[i];
            } else {
                int index = getLowerBound(result, a[i], j);
                result[index] = a[i];
            }
        }
        return (int)Arrays.stream(result).filter(e -> e >= 0).count();
    }

    private static int getLowerBound(int[] a, int k, int end) {
        int s = 0;
        int e = end;
        int mid = 0;
        while(s < e) {
            mid = s + (e - s)/2;
            if(a[mid] >= k)
                e = mid;
            else
                s = mid + 1;
        }

        if(s < end && a[s] < k)
            s++;

        return s;

    }

    public static void main(String[] args) {
        int n = 16;
        int[] a = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        solveOptimized(n, a);
        /*
        [[92,47,83],[75,20,87],[68,12,83],[12,85,15],[16,24,47],[69,65,35],[96,56,93],[89,93,11],[86,20,41],[69,77,12],[83,80,97],[90,22,36]]
         */
    }
}
