package dp;

import java.util.Arrays;

public class DiceThrow {
    static long noOfWays(int M , int N , int X) {
        return solve(M, N, X);
    }

    static int solve(int faces, int dice, int target) {
        if(target < 0)
            return 0;

        if(dice == 0 && target != 0)
            return 0;

        if(dice != 0 && target == 0)
            return 0;

        if(dice == 0 && target == 0)
            return 1;

        int sum = 0;

        for(int i = 1; i <= faces; i++) {
            sum += solve(faces, dice - 1, target - i);
        }

        return sum;
    }

    static long solveMemo(int faces, int dice, int target, long[][] dp) {
        if(target < 0)
            return 0;

        if(dice == 0 && target != 0)
            return 0;

        if(dice != 0 && target == 0)
            return 0;

        if(dice == 0)
            return 1;

        if(dp[dice][target] != -1)
            return dp[dice][target];

        long sum = 0;

        for(int i = 1; i <= faces; i++) {
            sum += solveMemo(faces, dice - 1, target - i, dp);
        }


        return dp[dice][target] = sum;
    }

    static long solveTab(int faces, int dice, int target) {
        long[][] dp = new long[dice + 1][target + 1];
        dp[0][0] = 1;


        for(int d = 1; d <= dice; d++) {
            for(int t = 1; t <= target; t++) {
                long sum = 0;
                for(int i = 1; i <= faces; i++) {
                    if(t - i >= 0)
                        sum += dp[d - 1][t - i];
                }
                dp[d][t] = sum;
            }
        }

        return dp[dice][target];
    }

    static long solveTab2(int faces, int dice, int target) {
        long[] previous = new long[target + 1];
        previous[0] = 1;


        for(int d = 1; d <= dice; d++) {
            long[] current = new long[target + 1];
            for(int t = 1; t <= target; t++) {
                long sum = 0;
                for(int i = 1; i <= faces; i++) {
                    if(t - i >= 0)
                        sum += previous[t - i];
                }
                current[t] = sum;
            }
            previous = current;
        }

        return previous[target];
    }

    public static void main(String[] args) {
        long[][] dp = new long[5 + 1][6 + 1];
    }
}
