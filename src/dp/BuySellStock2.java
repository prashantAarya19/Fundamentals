package dp;

public class BuySellStock2 {
    public int maxProfit(int[] prices) {
        return solve(prices, 0, true);
    }

    private int solve(int[] prices, int index, boolean isBuyAllowed) {
        if(index == prices.length)
            return 0;

        int maxProfit = Integer.MIN_VALUE;
        if(isBuyAllowed) {
            int buy = - prices[index] + solve(prices, index + 1, false);
            int skipBuy = solve(prices, index + 1, true);
            maxProfit = Math.max(buy, skipBuy);
        } else {
            int sell = prices[index] + solve(prices, index + 1, true);
            int skipSell = solve(prices, index + 1, false);
            maxProfit = Math.max(sell, skipSell);
        }

        return maxProfit;

    }

    private int solveMemo(int[] prices, int index, int isBuyAllowed, int[][] dp) {
        if(index == prices.length)
            return 0;
        if(dp[index][isBuyAllowed] != -1)
            return dp[index][isBuyAllowed];

        int maxProfit = Integer.MIN_VALUE;
        if(isBuyAllowed == 1) {
            int buy = - prices[index] + solveMemo(prices, index + 1, 0, dp);
            int skipBuy = solveMemo(prices, index + 1, 1, dp);
            maxProfit = Math.max(buy, skipBuy);
        } else {
            int sell = prices[index] + solveMemo(prices, index + 1, 1, dp);
            int skipSell = solveMemo(prices, index + 1, 0, dp);
            maxProfit = Math.max(sell, skipSell);
        }

        return dp[index][isBuyAllowed] = maxProfit;
    }

    private int solveTab(int[] prices, int i) {
        int[][] dp = new int[prices.length + 1][2];

        for(int index = prices.length - 1; index >= 0; index--) {
            for(int isBuyAllowed = 0; isBuyAllowed <= 1; isBuyAllowed++) {
                int maxProfit = Integer.MIN_VALUE;
                if(isBuyAllowed == 1) {
                    int buy = - prices[index] + dp[index + 1][0];
                    int skipBuy = dp[index + 1][1];
                    maxProfit = Math.max(buy, skipBuy);
                } else {
                    int sell = prices[index] + dp[index + 1][1];
                    int skipSell = dp[index + 1][0];
                    maxProfit = Math.max(sell, skipSell);
                }
                dp[index][isBuyAllowed] = maxProfit;
            }
        }
        return dp[0][1];
    }

    private int solveTab2(int[] prices, int i) {
        int[] next = new int[2];

        for(int index = prices.length - 1; index >= 0; index--) {
            int[] current = new int[2];
            for(int isBuyAllowed = 0; isBuyAllowed <= 1; isBuyAllowed++) {
                int maxProfit = Integer.MIN_VALUE;
                if(isBuyAllowed == 1) {
                    int buy = - prices[index] + next[0];
                    int skipBuy = next[1];
                    maxProfit = Math.max(buy, skipBuy);
                } else {
                    int sell = prices[index] + next[1];
                    int skipSell = next[0];
                    maxProfit = Math.max(sell, skipSell);
                }
                current[isBuyAllowed] = maxProfit;
            }
            next = current;
        }
        return next[1];
    }
}
