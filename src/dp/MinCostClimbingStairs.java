package dp;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int start = 0;
        int minCost = 0;
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        minCost += Integer.min(minCostUtil1(cost, start, dp), minCostUtil1(cost, start + 1, dp));
        return minCost;
    }

    // Using memoization --> Top to Bottom
    private int minCostUtil1(int[] cost, int start, int[] dp) {
        if(start >= cost.length - 2)
            return cost[start];

        if(dp[start] != -1)
            return dp[start];
        dp[start] = Integer.min(minCostUtil1(cost, start + 1, dp), minCostUtil1(cost, start + 2, dp)) + cost[start];
        return dp[start];
    }

    public static void main(String[] args) {
        int[] cost = new int[] {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostTabulation(cost));
    }

    private static int minCostTabulation(int[] cost) {
        int n = cost.length;
        int[] tab = new int[n + 1];

        tab[0] = cost[0];
        tab[1] = cost[1];

        for (int i = 2; i < n; i++) {
            tab[i] = Integer.min(tab[i - 1], tab[i - 2]) + cost[i];
        }
        return Integer.min(tab[n - 1], tab[n - 2]);
    }
    private static int minCostMemoryOptimized(int[] cost) {
        int n = cost.length;
        int previous1Cost = cost[1];
        int previous2Cost = cost[0];

        if(n == 3)
            return previous1Cost;

        for (int i = 2; i < n; i++) {
            int currentCost = cost[i] + Integer.min(previous1Cost, previous2Cost);
            previous2Cost = previous1Cost;
            previous1Cost = currentCost;
        }
        return Integer.min(previous1Cost, previous2Cost);
    }


}
