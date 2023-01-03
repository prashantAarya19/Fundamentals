package dp;

import java.util.Arrays;

public class MaxSquare {
    public static int max = 0;

    public static void main(String[] args) {
        int n = 5;
        int m = 6;

        int[][] mat = {{0, 1, 0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0},
                        {0, 1, 1, 1, 1, 0},
                        {0, 0, 1, 1, 1, 0},
                        {1, 1, 1, 1, 1, 1}};
        System.out.println(maxSquare(n, m, mat));
    }
    static int maxSquare(int n, int m, int mat[][]){
        max = 0;
        int i = 0;
        int j = 0;
        solveRecursive(i, j, mat);
        return max;

    }

    static int solveRecursive(int i, int j, int[][] mat) {
        if(i >= mat.length || j >= mat[0].length)
            return 0;

        int right = solveRecursive(i, j+1, mat);
        int diagonal = solveRecursive(i + 1, j + 1, mat);
        int down = solveRecursive(i + 1, j, mat);

        if(mat[i][j] == 1) {
            int minSq = 1 + Integer.min(right, Integer.min(diagonal, down));
            max = Integer.max(max, minSq);
            return minSq;
        } else {
            return 0;
        }
    }

    static int solveDP(int i, int j, int[][] mat, int[][] dp) {
        if(i >= mat.length || j >= mat[0].length)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int right = solveDP(i, j+1, mat, dp);
        int diagonal = solveDP(i + 1, j + 1, mat, dp);
        int down = solveDP(i + 1, j, mat, dp);

        if(mat[i][j] == 1) {
            dp[i][j] = 1 + Integer.min(right, Integer.min(diagonal, down));
            max = Integer.max(max, dp[i][j]);
            return dp[i][j];
        } else {
            return dp[i][j] = 0;
        }
    }

    static int solveTab(int n, int m, int[][] mat) {
        int[][] dp = new int[n + 1][m + 1];

        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                int right = dp[i][j + 1];
                int diagonal = dp[i + 1][j + 1];
                int down = dp[i + 1][j];

                if(mat[i][j] == 1) {
                    dp[i][j] = 1 + Integer.min(right, Integer.min(diagonal, down));
                    max = Integer.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

    static int solveTab2(int n, int m, int[][] mat) {
        int[] next = new int[m + 1];

        for(int i = n - 1; i >= 0; i--) {
            int[] current = new int[m + 1];
            for(int j = m - 1; j >= 0; j--) {
                int right = current[j + 1];
                int diagonal = next[j + 1];
                int down = next[j];

                if(mat[i][j] == 1) {
                    current[j] = 1 + Integer.min(right, Integer.min(diagonal, down));
                    max = Integer.max(max, current[j]);
                } else {
                    current[j] = 0;
                }
            }
            next = current;
        }
        return max;
    }
}
