package dp;

import java.util.Arrays;

public class CountDerangements {
    public static int MOD = 1000000007;
    public static long countDerangements(int n) {
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        return getDearrangeMents(n, dp);
    }

    public static long getDearrangeMents(int n, long[] dp) {
        if(n == 1)
            return 0;
        if(n == 2)
            return 1;
        if(dp[n] != -1)
            return dp[n];

        dp[n] = (((n - 1)%MOD) * ((getDearrangeMents(n - 1, dp)%MOD) + (getDearrangeMents(n - 2, dp)%MOD))%MOD)%MOD;
        return dp[n];
    }

    public static long getDerangementsTab(int n) {
        long[] dp = new long[n+1];

        dp[1] = 0;
        dp[2] = 1;

        for(int i = 3; i <= n; i++) {
            dp[i] = ( ((i - 1)%MOD) * ( dp[i - 1]%MOD + dp[i - 2]%MOD )%MOD )%MOD;
        }

        return dp[n];
    }

    public static long getDerangementsOptimized(int n) {
        long prev1 = 1;
        long prev2 = 0;

        for(int i = 3; i <= n; i++) {
            long result = ((i - 1)%MOD * (prev1%MOD + prev2%MOD)%MOD) %MOD;
            prev2 = prev1;
            prev1 = result;
        }
        return prev1;
    }
}
