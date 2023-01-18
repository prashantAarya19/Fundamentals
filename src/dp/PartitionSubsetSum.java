package dp;

import java.util.Arrays;

public class PartitionSubsetSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        System.out.println((100 & 1) == 1);
    }

    static int equalPartition(int N, int arr[])
    {
        if(N == 0)
            return 0;

        int sum = Arrays.stream(arr).sum();

        if((sum & 1) == 1)
            return 0;
        else
            return solve(0, N, arr, sum/2);
    }

    static int solve(int start, int end, int[] arr, int target) {
        if(start >= end || target < 0)
            return 0;

        if(target == 0)
            return 1;

        int include = solve(start + 1, end, arr, target - arr[start]);
        int exclude = solve(start + 1, end, arr, target);

        return (include == 1) || (exclude == 1) ? 1 : 0;
    }

    static int solveMemo(int start, int end, int[] arr, int target, int[][] dp) {
        if(start >= end || target < 0)
            return 0;

        if(target == 0)
            return 1;

        if(dp[start][target] != -1)
            return dp[start][target];

        int include = solveMemo(start + 1, end, arr, target - arr[start], dp);
        int exclude = solveMemo(start + 1, end, arr, target, dp);

        dp[start][target] = (include == 1) || (exclude == 1) ? 1 : 0;

        return dp[start][target];
    }

    static int solveTab(int start, int end, int[] arr, int target) {
        int[][] dp = new int[end + 1][target + 1];
        Arrays.stream(dp).forEach(e -> e[0] = 1);

        for(int s = end - 1; s >= 0; s--) {
            for(int t = 0; t <= target; t++) {
                int include = 0;
                if(t - arr[s] >= 0)
                    include = dp[s + 1][t - arr[s]];
                int exclude = dp[s + 1][t];
                dp[s][t] = (include == 1) || (exclude == 1) ? 1 : 0;
            }
        }

        return dp[0][target];
    }

    static int solveTab2(int start, int end, int[] arr, int target) {
        int[] next = new int[target + 1];
        next[0] = 1;

        for(int s = end - 1; s >= 0; s--) {
            int[] current = new int[target + 1];
            for(int t = 0; t <= target; t++) {
                int include = 0;
                if(t - arr[s] >= 0)
                    include = next[t - arr[s]];
                int exclude = next[t];
                current[t] = (include == 1) || (exclude == 1) ? 1 : 0;
            }
            next = current;
        }

        return next[target];
    }
}
