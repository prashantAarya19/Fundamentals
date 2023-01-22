package dp;

public class BuySellStock4 {
    public int maxProfit(int k, int[] prices) {
        return solve(k, prices, 0, 1);
    }

    private int solve(int transactionLimit, int[] prices, int index, int isBuyAllowed) {
        if(index == prices.length || transactionLimit == 0)
            return 0;

        int maxProfit;
        if(isBuyAllowed == 1) {
            int buy = -prices[index] + solve(transactionLimit, prices, index + 1, 0);
            int skipBuy = solve(transactionLimit, prices, index + 1, 1);
            maxProfit = Math.max(buy, skipBuy);
        } else {
            int sell = prices[index] + solve(transactionLimit - 1, prices, index + 1, 1);
            int skipSell = solve(transactionLimit, prices, index + 1, 0);
            maxProfit = Math.max(sell, skipSell);
        }

        return maxProfit;
    }

    private int solveMemo(int transactionLimit, int[] prices, int index, int isBuyAllowed, int[][][] dp) {
        if(index == prices.length || transactionLimit == 0)
            return 0;

        if(dp[index][isBuyAllowed][transactionLimit] != -1)
            return dp[index][isBuyAllowed][transactionLimit];

        int maxProfit;
        if(isBuyAllowed == 1) {
            int buy = -prices[index] + solveMemo(transactionLimit, prices, index + 1, 0, dp);
            int skipBuy = solveMemo(transactionLimit, prices, index + 1, 1, dp);
            maxProfit = Math.max(buy, skipBuy);
        } else {
            int sell = prices[index] + solveMemo(transactionLimit - 1, prices, index + 1, 1, dp);
            int skipSell = solveMemo(transactionLimit, prices, index + 1, 0, dp);
            maxProfit = Math.max(sell, skipSell);
        }

        return dp[index][isBuyAllowed][transactionLimit] = maxProfit;
    }

    private int solveTab(int tl, int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][tl + 1];

        for(int index = prices.length - 1; index >= 0; index--) {
            for(int isBuyAllowed = 0; isBuyAllowed <= 1; isBuyAllowed++) {
                for(int transactionLimit = 1; transactionLimit <= tl; transactionLimit++) {
                    int maxProfit;
                    if(isBuyAllowed == 1) {
                        int buy = -prices[index] + dp[index + 1][0][transactionLimit];
                        int skipBuy = dp[index + 1][1][transactionLimit];
                        maxProfit = Math.max(buy, skipBuy);
                    } else {
                        int sell = prices[index] + dp[index + 1][1][transactionLimit - 1];
                        int skipSell = dp[index + 1][0][transactionLimit];
                        maxProfit = Math.max(sell, skipSell);
                    }

                    dp[index][isBuyAllowed][transactionLimit] = maxProfit;
                }
            }
        }

        return dp[0][1][tl];

    }

    private int solveTab2(int tl, int[] prices) {
        int[][] next = new int[2][tl + 1];

        for(int index = prices.length - 1; index >= 0; index--) {
            int[][] current = new int[2][tl + 1];
            for(int isBuyAllowed = 0; isBuyAllowed <= 1; isBuyAllowed++) {
                for(int transactionLimit = 1; transactionLimit <= tl; transactionLimit++) {
                    int maxProfit;
                    if(isBuyAllowed == 1) {
                        int buy = -prices[index] + next[0][transactionLimit];
                        int skipBuy = next[1][transactionLimit];
                        maxProfit = Math.max(buy, skipBuy);
                    } else {
                        int sell = prices[index] + next[1][transactionLimit - 1];
                        int skipSell = next[0][transactionLimit];
                        maxProfit = Math.max(sell, skipSell);
                    }

                    current[isBuyAllowed][transactionLimit] = maxProfit;
                }
            }
            next = current;
        }

        return next[1][tl];

    }
}
