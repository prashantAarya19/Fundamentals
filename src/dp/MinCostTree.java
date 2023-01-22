package dp;

import java.util.HashMap;
import java.util.Map;

public class MinCostTree {
    public static void main(String[] args) {
        Map<Pair2, Integer> maxMap = new HashMap<>();
        maxMap.put(new Pair2(3, 4), 3);
        System.out.println(maxMap.get(new Pair2(3, 4)));
    }

    public int mctFromLeafValues(int[] arr) {
        Map<Pair2, Integer> maxMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            maxMap.put(new Pair2(i, i), arr[i]);
            for(int j = i + 1; j < arr.length; j++) {
                maxMap.put(new Pair2(i, j), Math.max(arr[j], maxMap.get(new Pair2(i, j - 1))));
            }
        }

        return solve(arr, 0, arr.length - 1, maxMap);
    }

    private int solve(int[] arr, int left, int right, Map<Pair2, Integer> maxMap) {
        if(left == right)
            return 0;
        /*
            For each i in range left <-> right = ( max(left, i) * max(i + 1, right) ) + leftPart(left, i) + rightPart(i + 1, right)
        */
        int min = Integer.MAX_VALUE;
        for(int i = left; i < right; i++) {
            min = Math.min(min,
                    (maxMap.get(new Pair2(left, i)) * maxMap.get(new Pair2(i + 1, right))) + solve(arr, left, i, maxMap) + solve(arr, i + 1, right, maxMap) );
        }

        return min;
    }

    private void printMaxMap(Map<Pair2, Integer> maxMap) {
        for(Pair2 p : maxMap.keySet()) {
            System.out.println(p.first +" -> "+p.second+" "+maxMap.get(p));
        }
    }

    private int solveDP(int[] arr, int left, int right, Map<Pair, Integer> maxMap, int[][] dp) {
        if(left == right)
            return 0;

        if(dp[left][right] != -1)
            return dp[left][right];
        /*
            For each i in range left <-> right = ( max(left, i) * max(i + 1, right) ) + leftPart(left, i) + rightPart(i + 1, right)
        */
        int min = Integer.MAX_VALUE;
        for(int i = left; i < right; i++) {
            min = Math.min(min,
                    (maxMap.get(new Pair(left, i)) * maxMap.get(new Pair(i + 1, right))) + solveDP(arr, left, i, maxMap, dp) + solveDP(arr, i + 1, right, maxMap, dp) );
        }

        return dp[left][right] = min;
    }

    private int solveTab(int[] arr, int l, int r, Map<Pair, Integer> maxMap) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];

        for(int left = r; left >= 0; left--) {
            for(int right = l; right <= r; right++) {
                if(left != right) {
                    int min = Integer.MAX_VALUE;
                    for(int i = left; i < right; i++) {
                        min = Math.min(min,
                                (maxMap.get(new Pair(left, i)) * maxMap.get(new Pair(i + 1, right))) + dp[left][i] + dp[i + 1][right]);
                    }
                    dp[left][right] = min;
                }
            }
        }
        /*
            For each i in range left <-> right = ( max(left, i) * max(i + 1, right) ) + leftPart(left, i) + rightPart(i + 1, right)
        */


        return dp[l][r];
    }
}
