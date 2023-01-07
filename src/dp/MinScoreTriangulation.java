package dp;

public class MinScoreTriangulation {
    public int minScoreTriangulation(int[] values) {
        int i = 0;
        int j = values.length - 1;
        return solveRecursively(values, i, j);
    }

    private int solveRecursively(int[] values, int i, int j) {
        if(i + 1 == j)
            return 0;

        int ans = Integer.MAX_VALUE;
        for(int k = i + 1; k < j; k++) {
            ans = Integer.min(ans, values[i] * values[j] * values[k] + solveRecursively(values, i, k) + solveRecursively(values, k, j));
        }
        return ans;
    }

    private int solveMemo(int[] values, int i, int j, int[][] dp) {
        if(i + 1 == j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for(int k = i + 1; k < j; k++) {
            ans = Integer.min(ans, values[i] * values[j] * values[k] + solveMemo(values, i, k, dp) + solveMemo(values, k, j, dp));
        }
        dp[i][j] = ans;
        return dp[i][j];
    }

    private int solveMemo(int[] values) {
        int[][] dp = new int[values.length][values.length];
        int n = values.length;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 2; j < n; j++) {
                int ans = Integer.MAX_VALUE;
                for(int k = i + 1; k < j; k++) {
                    ans = Integer.min(ans, values[i] * values[j] * values[k] + dp[i][k] + dp[k][j]);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][n - 1];
    }
}
