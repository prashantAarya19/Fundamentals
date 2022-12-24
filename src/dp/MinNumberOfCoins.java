package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class MinNumberOfCoins {
    public static int minimumElements(int[] num, int x) {
        int minCoins = minCoinCalculatorRecursive(num, x);

        if(minCoins == Integer.MAX_VALUE)
            return -1;
        else
            return minCoins;
    }

    private static int minCoinCalculatorRecursive(int[] num, int x) {
        if(x < 0)
            return Integer.MAX_VALUE;

        if(x == 0)
            return 0;

        int minCoins = Integer.MAX_VALUE;

        for(int i = 0; i < num.length; i++) {
            int coins = minCoinCalculatorRecursive(num, x - num[i]);
            if(coins != Integer.MAX_VALUE)
                minCoins = Integer.min(coins + 1, minCoins);
        }
        return minCoins;
    }

    private static int minCoinCalculatorMemo(int[] num, int x, Map<Integer, Integer> memo) {
        if(x < 0)
            return Integer.MAX_VALUE;

        if(x == 0)
            return 0;

        if(memo.get(x) != null)
            return memo.get(x);

        int minCoins = Integer.MAX_VALUE;

        for(int i = 0; i < num.length; i++) {
            int coin = minCoinCalculatorMemo(num, x - num[i], memo);
            if(coin != Integer.MAX_VALUE)
                minCoins = Integer.min(coin + 1, minCoins);
        }
        memo.put(x, minCoins);
        return minCoins;
    }

    private static int minCoinCalculatorTabulation(int[] num, int x) {
        int[] tab = new int[x + 1];
        Arrays.fill(tab, Integer.MAX_VALUE);
        tab[0] = 0;
        for(int i = 1; i <= x; i++) {
            for(int j = 0; j < num.length; j++) {
                if(i - num[j] >= 0 && tab[i - num[j]] != Integer.MAX_VALUE) {
                    tab[i] = Integer.min(tab[i - num[j]] + 1, tab[i]);
                }
            }
        }
        return tab[x];
    }

    public static void main(String[] args) {
        int[] arr = new int[2];
        System.out.println(arr[-1]);
    }
}
