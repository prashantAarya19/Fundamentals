package dp;

public class CombinationSum {
    public static int findWays(int num[], int tar) {
        return solveRecursive(num, tar);
    }

    public static int solveRecursive(int[] nums, int tar) {
        if(tar < 0)
            return 0;
        if(tar == 0)
            return 1;
        int numberOfWays = 0;
        for(int i = 0; i < nums.length; i++) {
            numberOfWays += solveRecursive(nums, tar - nums[i]);
        }
        return numberOfWays;
    }

    public static int solveMemo(int[] nums, int tar, int[] dp) {
        if(tar < 0)
            return 0;
        if(tar == 0)
            return 1;
        if(dp[tar] != -1)
            return dp[tar];

        int numberOfWays = 0;
        for(int i = 0; i < nums.length; i++) {
            numberOfWays += solveMemo(nums, tar - nums[i], dp);
        }
        dp[tar] = numberOfWays;
        return dp[tar];
    }

    public static int solveTab(int[] nums, int tar) {
        int[] dp = new int[tar+1];
        dp[0] = 1;

        for(int i = 1; i <= tar; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i >= nums[j])
                    dp[i] += dp[i - nums[j]];
            }
        }
        return dp[tar];
    }

}
