package dp;

public class CoinChange {
    public long count(int[] coins, int N, int sum) {
        return solve(coins, N - 1, sum);
    }

    public long solve(int[] coins, int n, int sum) {
        if(n < 0) {
            return 0;
        }

        if(sum == 0) {
            return 1;
        }

        long include = 0;
        if(coins[n] <= sum)
            include = solve(coins, n, sum - coins[n]);

        long exclude = solve(coins, n - 1, sum);

        return include + exclude;
    }

    private long solve(int[] coins, int sum) {
        long[][] dp = new long[coins.length][sum  + 1];

        for(int i = 0; i <= sum; i++) {
            dp[0][i] = i % coins[0] == 0 ? 1 : 0;
        }

        for(int ind = 1; ind < coins.length; ind++) {
            for(int target = 0; target <= sum; target++) {
                long include = 0L;
                if(coins[ind] <= target)
                    include = dp[ind][target - coins[ind]];

                long exclude = dp[ind - 1][target];
                dp[ind][target] = include + exclude;
            }
        }

        return dp[coins.length - 1][sum];
    }
}
