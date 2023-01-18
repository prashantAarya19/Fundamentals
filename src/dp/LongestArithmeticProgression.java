package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticProgression {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
//        int[] arr = new int[]{5, 9, 10, 14};
        int[] arr = new int[]{1, 7, 10, 13, 14, 19};
        System.out.println(lengthOfLongestAPTab(arr, 5));

    }

    int lengthOfLongestAP(int[] A, int n) {
        if(n <= 2) {
            return n;
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int diff = A[j] - A[i];
                count = Integer.max(count, 2 + solve(A, i, diff));
            }
        }
        return count;
    }

    int solve(int[] a, int index, int diff) {
        if(index == 0)
            return 0;

        int count = 0;
        for(int j = index - 1; j >= 0; j--) {
            if(a[index] - a[j] == diff)
                count = Integer.max(count, 1 + solve(a, j, diff));
        }
        return count;

    }

    /**Need to recheck **/
    int solveMemo(int[] a, int index, int diff, Map<Integer, Integer>[] dp) {
        if(index < 0)
            return 0;
        if(dp[index].get(diff) != null)
            return dp[index].get(diff);

        int count = 0;
        for(int j = index - 1; j >= 0; j--) {
            if(a[index] - a[j] == diff)
                count = Integer.max(count, 1 + solveMemo(a, j, diff, dp));
        }
        dp[index].put(diff, count);
        return dp[index].get(diff);

    }

    static int lengthOfLongestAPTab(int[] A, int n) {
        if(n <= 2) {
            return n;
        }

        HashMap<Integer, Integer>[] dp = new HashMap[n + 1];
        int totalCount = 0;
        for(int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for(int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1)+1);
                totalCount = Integer.max(totalCount, dp[i].get(diff));
            }
        }
        return totalCount;
    }


}
