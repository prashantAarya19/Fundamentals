package dp;

public class BuySellStock1 {
    public int maxProfit(int[] prices) {
        return solve(prices);
    }

    private int solve(int[] prices) {
        int bCost = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            int diff = prices[i] - bCost;
            maxProfit = Math.max(maxProfit, diff);
            bCost = Math.min(bCost, prices[i]);
        }

        return maxProfit;
    }
}
