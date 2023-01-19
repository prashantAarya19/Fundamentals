package dp;

public class UniqueBST {
    public int numTrees(int n) {
        return solve(n);
    }

    private int solve(int n) {
        if(n <= 1)
            return 1;

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            ans += solve(i - 1) * solve(n - i);
        }

        return ans;
    }

    private int solveMemo(int n, int[] dp) {
        if(n <= 1)
            return 1;

        if(dp[n] != -1)
            return dp[n];

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            ans += solveMemo(i - 1, dp) * solveMemo(n - i, dp);
        }

        return dp[n] = ans;
    }

    private int solveTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
