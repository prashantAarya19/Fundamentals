package dp;

import java.util.Arrays;

public class NPizzaSlices {
    public static void main(String[] args) {
//        int[] slices = new int[]{1,2,3,4,5,6};
//        int[] slices = new int[]{8,9,8,6,1,1};
        int[] slices = new int[]{4,1,2,5,8,3,1,9,7};
        System.out.println(maxSizeSlices(slices));
    }

    private static int maxSizeSlices(int[] slices) {
        int end = slices.length;

//        int takeFirstSlice = solve(slices, 0, end - 2, end / 3);
//        int notTakeFirstSlice = solve(slices, 1, end - 1, end / 3);
        int[][] dp = new int[end + 1][(end / 3) + 1];
        Arrays.stream(dp).forEach(e -> Arrays.fill(e, -1));
        int takeFirstSlice = solveTab(slices, 0, end - 2, end / 3);
        int notTakeFirstSlice = solveTab(slices, 1, end - 1, end / 3);
        return Integer.max(takeFirstSlice, notTakeFirstSlice);
    }

    private static int solve(int[] slices, int start, int end, int k) {
        if(k == 0 || start > end)
            return 0;

        int include = slices[start] + solve(slices, start + 2, end, k - 1);
        int exclude = solve(slices, start + 1, end, k);

        return Integer.max(include, exclude);
    }

    private static int solveMemo(int[] slices, int start, int end, int k, int[][] dp) {
        if(k == 0 || start > end)
            return 0;

        if(dp[start][k] != -1)
            return dp[start][k];

        int include = slices[start] + solveMemo(slices, start + 2, end, k - 1, dp);
        int exclude = solveMemo(slices, start + 1, end, k, dp);

        return dp[start][k]= Integer.max(include, exclude);
    }

    private static int solveTab(int[] slices, int start, int end, int k) {
        int[][] dp = new int[end + 3][k + 1];

        for(int i = end; i >= start; i--) {
            for(int j = 1; j <= k; j++) {

                int include = slices[i] + dp[i + 2][j - 1];
                int exclude = dp[i + 1][j];

                dp[i][j]= Integer.max(include, exclude);
            }
        }

        return dp[start][k];
    }

    private static int solveTab2(int[] slices, int start, int end, int k) {
        int[] next1 = new int[end + 3];
        int[] next2 = new int[end + 3];

        for(int i = end; i >= start; i--) {
            int[] current = new int[end + 3];
            for(int j = 1; j <= k; j++) {

                int include = slices[i] + next2[j - 1];
                int exclude = next1[j];

                current[j]= Integer.max(include, exclude);
            }
            next1 = next2;
            next2 = current;
        }

        return next2[start];
    }

}
