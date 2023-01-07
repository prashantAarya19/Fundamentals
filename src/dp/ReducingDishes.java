package dp;

import java.util.Arrays;

public class ReducingDishes {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return solveRecursive(satisfaction, 0, 1);
    }

    private int solveRecursive(int[] satisfaction, int index, int unit) {
        if(index >= satisfaction.length)
            return 0;

        int include = unit * satisfaction[index] + solveRecursive(satisfaction, index + 1, unit + 1);
        int exclude = solveRecursive(satisfaction, index + 1, unit);
        return Integer.max(include, exclude);
    }

    private int solveMemo(int[] satisfaction, int index, int unit, int[][] dp) {
        if(index >= satisfaction.length)
            return 0;
        if(dp[index][unit] != -1)
            return dp[index][unit];
        int include = unit * satisfaction[index] + solveMemo(satisfaction, index + 1, unit + 1, dp);
        int exclude = solveMemo(satisfaction, index + 1, unit, dp);
        dp[index][unit] = Integer.max(include, exclude);
        return dp[index][unit];
    }

    private int solveTab(int[] satisfaction) {
        int[][] dp = new int[satisfaction.length + 1][satisfaction.length + 1];

        for(int index = satisfaction.length - 1; index >= 0; index--) {
            for(int unit = index; unit >= 0; unit--) {
                int include = (unit + 1) * satisfaction[index] + dp[index + 1][unit + 1];
                int exclude = dp[index + 1][unit];
                dp[index][unit] = Integer.max(include, exclude);
            }
        }
        return dp[0][0];
    }

    private int solveTab2(int[] satisfaction) {
        int[] next = new int[satisfaction.length + 1];

        for(int index = satisfaction.length - 1; index >= 0; index--) {
            int[] current = new int[satisfaction.length + 1];
            for(int unit = index; unit >= 0; unit--) {
                int include = (unit + 1) * satisfaction[index] + next[unit + 1];
                int exclude = next[unit];
                current[unit] = Integer.max(include, exclude);
            }
            next = current;
        }
        return next[0];
    }
}
