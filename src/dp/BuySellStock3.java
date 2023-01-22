package dp;

import java.util.Arrays;

public class BuySellStock3 {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        Arrays.stream(dp).forEach(e -> Arrays.stream(e).forEach(f -> Arrays.fill(f, -1)));
        return solve(prices, 0, 1, 2);
    }

    private int solve(int[] prices, int index, int isBuyAllowed, int transactionLeft) {
        if(index == prices.length)
            return 0;

        if(transactionLeft == 0)
            return 0;

        int maxProfit = 0;
        if(isBuyAllowed == 1) {
            int buy = - prices[index] + solve(prices, index + 1, 0, transactionLeft);
            int skipBuy = solve(prices, index + 1, 1, transactionLeft);
            maxProfit = Math.max(buy, skipBuy);
        }  else {
            int sell = prices[index] + solve(prices, index + 1, 1, transactionLeft - 1);
            int skipSell = solve(prices, index + 1, 0, transactionLeft);
            maxProfit = Math.max(sell, skipSell);
        }
        return maxProfit;
    }

    private int solveMemo(int[] prices, int index, int isBuyAllowed, int transactionLeft, int[][][] dp) {
        if(index == prices.length || transactionLeft == 0)
            return 0;

        if(dp[index][isBuyAllowed][transactionLeft] != -1)
            return dp[index][isBuyAllowed][transactionLeft];

        int maxProfit = 0;
        if(isBuyAllowed == 1) {
            int buy = - prices[index] + solveMemo(prices, index + 1, 0, transactionLeft, dp);
            int skipBuy = solveMemo(prices, index + 1, 1, transactionLeft, dp);
            maxProfit = Math.max(buy, skipBuy);
        }  else {
            int sell = prices[index] + solveMemo(prices, index + 1, 1, transactionLeft - 1, dp);
            int skipSell = solveMemo(prices, index + 1, 0, transactionLeft, dp);
            maxProfit = Math.max(sell, skipSell);
        }
        return dp[index][isBuyAllowed][transactionLeft] = maxProfit;
    }

    private int solveTab(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][3];

        for(int index = prices.length - 1; index >= 0; index--) {
            for(int isBuyAllowed = 0; isBuyAllowed <= 1; isBuyAllowed++) {
                for(int transactionLeft = 1; transactionLeft <= 2; transactionLeft++) {
                    int maxProfit = 0;
                    if(isBuyAllowed == 1) {
                        int buy = - prices[index] + dp[index + 1][0][transactionLeft];
                        int skipBuy = dp[index + 1][1][transactionLeft];
                        maxProfit = Math.max(buy, skipBuy);
                    }  else {
                        int sell = prices[index] + dp[index + 1][1][transactionLeft - 1];
                        int skipSell = dp[index + 1][0][transactionLeft];
                        maxProfit = Math.max(sell, skipSell);
                    }
                    dp[index][isBuyAllowed][transactionLeft] = maxProfit;
                }
            }
        }

        return dp[0][1][2];

    }

    private int solveTab2(int[] prices) {
        int[][] next = new int[2][3];

        for(int index = prices.length - 1; index >= 0; index--) {
            int[][] current = new int[2][3];
            for(int isBuyAllowed = 0; isBuyAllowed <= 1; isBuyAllowed++) {
                for(int transactionLeft = 1; transactionLeft <= 2; transactionLeft++) {
                    int maxProfit = 0;
                    if(isBuyAllowed == 1) {
                        int buy = - prices[index] + next[0][transactionLeft];
                        int skipBuy = next[1][transactionLeft];
                        maxProfit = Math.max(buy, skipBuy);
                    }  else {
                        int sell = prices[index] + next[1][transactionLeft - 1];
                        int skipSell = next[0][transactionLeft];
                        maxProfit = Math.max(sell, skipSell);
                    }
                    current[isBuyAllowed][transactionLeft] = maxProfit;
                }
            }
            next = current;
        }

        return next[1][2];

    }
}
