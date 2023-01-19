package dp;

import java.util.Arrays;

public class GuessHigherLower {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        Arrays.stream(dp).forEach(e -> Arrays.fill(e, -1));
        return getMinAmount(1, n, dp);
    }

    private int getMinAmount(int s, int n, int[][] dp) {
        if(s >= n)
            return 0;

        if(dp[s][n] != -1)
            return dp[s][n];

        int max = Integer.MAX_VALUE;
        for(int i = s; i <= n; i++) {
            max = Math.min(max, i + Math.max(getMinAmount(s, i - 1, dp), getMinAmount(i + 1, n, dp)));
        }

        return dp[s][n] = max;
    }

    private int getMinAmountTab(int s, int n) {
        int[][] dp = new int[n + 2][n + 2];

        for(int start = n; start >= s; start--) {
            for(int end = start; end <= n; end ++) {
                if(start != end) {
                    int max = Integer.MAX_VALUE;
                    for(int i = start; i <= end; i++) {
                        max = Math.min(max, i + Math.max(dp[start][i - 1], dp[i + 1][end]));
                    }
                    dp[start][end] = max;
                }
            }
        }
        return dp[s][n];
    }
}
