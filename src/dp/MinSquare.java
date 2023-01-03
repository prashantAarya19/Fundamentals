package dp;

import java.util.Arrays;

public class MinSquare {
    private int solveRecursive(int n) {
        if(n == 0)
            return 0;

        int minVal = n;
        for(int i = 1; i * i <= n; i++) {
            minVal = Integer.min(minVal, 1 + solveRecursive(n - i * i));
        }
        return minVal;
    }

    private int solveMemo(int n, int[] dp) {
        if(n == 0)
            return 0;

        if(dp[n] != -1)
            return dp[n];

        int minVal = n;
        for(int i = 1; i * i <= n; i++) {
            minVal = Integer.min(minVal, 1 + solveMemo(n - i * i, dp));
        }
        dp[n] = minVal;
        return dp[n];
    }

    private int solveTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            int minVal = i;
            for(int j = 1; j*j <= i; j++) {
                if(i >= j * j)
                    minVal = Integer.min(minVal, 1 + dp[i - j * j]);
            }
            dp[i] = minVal;
        }

        return dp[n];
    }

    private int solveTab2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j*j <= i; j++) {
                if(i >= j * j)
                    dp[i] = Integer.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }
}
