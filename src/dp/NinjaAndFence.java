package dp;

public class NinjaAndFence {
    public static int MOD = 1000000007;
    public static int sum(int a, int b) {
        return (a%MOD + b%MOD)%MOD;
    }

    public static int multiply(int a, int b) {
        return (a%MOD * b%MOD)%MOD;
    }
    public static int numberOfWays(int n, int k) {
        return solveRecursive(n, k);
    }

    public static int solveRecursive(int n, int k) {
        if(n == 1)
            return k;
        if(n == 2)
            return sum(k, multiply(k, k - 1));
        int same = multiply(solveRecursive(n - 2, k), (k - 1));
        int diff = multiply(solveRecursive(n - 1, k), (k - 1));
        return sum(same, diff);
    }

    public static int solveMemo(int n, int k, int[] dp) {
        if(n == 1)
            return k;
        if(n == 2)
            return sum(k, multiply(k, k - 1));
        if(dp[n] != -1)
            return dp[n];
        int same = multiply(solveMemo(n - 2, k, dp), (k - 1));
        int diff = multiply(solveMemo(n - 1, k, dp), (k - 1));
        dp[n] = sum(same, diff);
        return dp[n];
    }

    public static int solveTab(int n, int k) {
        int[] dp = new int[n+1];
        dp[1] = k;
        dp[2] = sum(k, multiply(k, k - 1));
        for(int i = 3; i <= n; i++) {
            int same = multiply(dp[i - 2], k - 1);
            int diff = multiply(dp[i - 1], k - 1);
            dp[i] = sum(same, diff);
        }

        return dp[n];
    }

    public static int solveOptmized(int n, int k) {
        int prev2 = k;
        int prev1 = sum(k, multiply(k, k - 1));
        for(int i = 3; i <= n; i++) {
            int same = multiply(prev2, k - 1);
            int diff = multiply(prev1, k - 1);
            int result = sum(same, diff);
            prev2 = prev1;
            prev1 = result;
        }

        return prev1;
    }
}
