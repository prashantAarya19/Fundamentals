package dp;

import java.util.Arrays;

public class KnapSack {
    public static int solveRecursive(int[] weight, int[] value, int index, int maxWeight) {
        if(index == 0) {
            if(weight[index] <= maxWeight)
                return value[index];
            else
                return 0;
        }

        int include = 0;
        if(weight[index] <= maxWeight)
            include = value[index] + solveRecursive(weight, value, index - 1, maxWeight - weight[index]);
        int exclude = solveRecursive(weight, value, index - 1, maxWeight);

        return Integer.max(include, exclude);
    }

    public static int solveMemo(int[] weight, int[] value, int index, int maxWeight, int[][] dp) {
        if(index == 0) {
            if(weight[index] <= maxWeight)
                return value[index];
            else
                return 0;
        }

        if(dp[index][maxWeight] != -1)
            return dp[index][maxWeight];

        int include = 0;
        if(weight[index] <= maxWeight)
            include = value[index] + solveMemo(weight, value, index - 1, maxWeight - weight[index], dp);
        int exclude = solveMemo(weight, value, index - 1, maxWeight, dp);

        dp[index][maxWeight] = Integer.max(include, exclude);
        return dp[index][maxWeight];
    }

    public static int solveTab(int[] weight, int[] value, int index, int maxWeight) {
        int[][] dp = new int[index + 1][maxWeight + 1];
        for(int i = weight[0]; i <= maxWeight; i++) {
            if(weight[0] <= maxWeight)
                dp[0][i] = value[0];
        }

        for(int i = 1; i <= index; i++) {
            for(int w = 0; w <= maxWeight; w++) {
                int include = 0;
                if(weight[i] <= w)
                    include = value[i];
                if(w - weight[i] >=0)
                    include += dp[i-1][w - weight[i]];
                int exclude = dp[i - 1][w];
                dp[i][w] = Integer.max(include, exclude);
            }
        }

        return dp[index][maxWeight];
    }

    public static int solveTab2(int[] weight, int[] value, int index, int maxWeight) {
        int[] previous = new int[maxWeight + 1];

        for(int i = weight[0]; i <= maxWeight; i++) {
            previous[i] = value[0];
        }

        for(int i = 1; i <= index; i++) {
            int[] current = new int[maxWeight + 1];
            for(int w = 0; w <= maxWeight; w++) {
                int include = 0;
                if(weight[i] <= w)
                    include = value[i] + previous[w - weight[i]];
                int exclude = previous[w];
                current[w] = Integer.max(include, exclude);
            }
            previous = current;
        }
        return previous[maxWeight];
    }

    public static int solveTab3(int[] weight, int[] value, int index, int maxWeight) {
        int[] current = new int[maxWeight + 1];
        for(int i = weight[0]; i <= maxWeight; i++) {
                current[i] = value[0];
        }

        for(int i = 1; i <= index; i++) {
            for(int w = maxWeight; w >= 0; w--) {
                int include = 0;
                if(w >= weight[i])
                    include = value[i] + current[w - weight[i]];
                int exclude = current[w];
                current[w] = Integer.max(include, exclude);
            }
        }
        return current[maxWeight];
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 4, 5};
        int[] values = {5, 4, 8, 6};
        int maxWeight = 5;
        int n = 4;
        System.out.println(solveTab3(weights, values, n - 1, maxWeight));
    }
}
