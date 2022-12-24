package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxNonAdjSum {
    public static int getMaxSumTab(ArrayList<Integer> nums, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = nums.get(0);

        for(int i = 1; i < n; i++) {
            int include = nums.get(i);
            if(i - 2 >= 0) {
                include += dp[i - 2];
            }
            int exclude = dp[i - 1];
            //System.out.println(i);
            dp[i] = Integer.max(include, exclude);
        }

        return dp[n - 1];
    }

    private static int getMaxSumOptimized(ArrayList<Integer> nums, int n) {
        int previous2 = 0;
        int previous1 = nums.get(0);

        for(int i = 1; i < n; i++) {
            int include = nums.get(i) + previous2;
            int exclude = previous1;
            int result = Integer.max(include, exclude);
            previous2 = previous1;
            previous1 = result;
        }
        return previous1;
    }

}
