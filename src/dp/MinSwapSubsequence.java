package dp;

import java.util.Arrays;

public class MinSwapSubsequence {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5,4};
        int[] nums2 = new int[]{1,2,3,7};
        boolean b = false;
        int a = nums1[b ? 0 : 1];
        System.out.println(minSwap(nums1, nums2));
    }

    public static int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        boolean isSwapped = false;
        int[] nums1Copy = new int[n + 1];
        getCoppiedArray(nums1, nums1Copy);
        int[] nums2Copy = new int[n + 1];
        getCoppiedArray(nums2, nums2Copy);
        return solve(nums1Copy, nums2Copy, 1, n  + 1, isSwapped);
    }

    private static void getCoppiedArray(int[] source, int[] copy) {
        System.arraycopy(source, 0, copy, 1, source.length);
        copy[0] = -1;
    }

    private static int solve(int[] nums1, int[] nums2, int start, int end, boolean isSwapped) {
        if(start == end)
            return 0;

        int previous1 = nums1[start - 1];
        int previous2 = nums2[start - 1];

        if(isSwapped) {
            //System.out.println("is swap");
            int temp = previous1;
            previous1 = previous2;
            previous2 = temp;
        }

        int swaps = Integer.MAX_VALUE;
        // No swaps
        if(nums1[start] > previous1 && nums2[start] > previous2) {
            System.out.println("no swap");
            swaps = solve(nums1, nums2, start + 1, end, false);
        }

        // if swap
        if(nums1[start] > previous2 && nums2[start] > previous1) {
            System.out.println("inside swap");
            swaps = Math.min(swaps, 1 + solve(nums1, nums2, start + 1, end, true));
        }

        return swaps;
    }

    private int solveMem(int[] nums1, int[] nums2, int start, int end, boolean isSwapped, int[][] dp) {
        if(start == end)
            return 0;

        int previous1 = nums1[start - 1];
        int previous2 = nums2[start - 1];

        if(isSwapped) {
            int temp = previous1;
            previous1 = previous2;
            previous2 = temp;
        }

        if(dp[start][isSwapped ? 1 : 0] != -1)
            return dp[start][isSwapped ? 1 : 0];

        int swaps = Integer.MAX_VALUE;
        // No swaps
        if(nums1[start] > previous1 && nums2[start] > previous2) {
            swaps = solveMem(nums1, nums2, start + 1, end, false, dp);
        }

        // if swap
        if(nums1[start] > previous2 && nums2[start] > previous1) {
            swaps = Math.min(swaps, 1 + solveMem(nums1, nums2, start + 1, end, true, dp));
        }
        dp[start][isSwapped ? 1 : 0] = swaps;
        return dp[start][isSwapped ? 1 : 0];
    }

    private int solveTab1(int[] nums1, int[] nums2, int start, int end) {
        int[][] dp = new int[end + 1][2];

        for(int i = end - 1; i >= 1; i--) {
            for(int j = 1; j >= 0; j--) {
                int previous1 = nums1[i - 1];
                int previous2 = nums2[i - 1];

                if(j == 1) {
                    int temp = previous1;
                    previous1 = previous2;
                    previous2 = temp;
                }

                int swaps = Integer.MAX_VALUE;
                // No swaps
                if(nums1[i] > previous1 && nums2[i] > previous2) {
                    swaps = dp[i + 1][0];
                }

                // if swap
                if(nums1[i] > previous2 && nums2[i] > previous1) {
                    swaps = Math.min(swaps, 1 + dp[i+1][1]);
                }
                dp[i][j] = swaps;
            }
        }
        return dp[1][0];
    }

    private int solveTab2(int[] nums1, int[] nums2, int start, int end) {
        int[] next = new int[2];

        for(int i = end - 1; i >= 1; i--) {
            int[] current = new int[2];
            for(int j = 1; j >= 0; j--) {
                int previous1 = nums1[i - 1];
                int previous2 = nums2[i - 1];

                if(j == 1) {
                    int temp = previous1;
                    previous1 = previous2;
                    previous2 = temp;
                }

                int swaps = Integer.MAX_VALUE;
                // No swaps
                if(nums1[i] > previous1 && nums2[i] > previous2) {
                    swaps = next[0];
                }

                // if swap
                if(nums1[i] > previous2 && nums2[i] > previous1) {
                    swaps = Math.min(swaps, 1 + next[1]);
                }
                current[j] = swaps;
            }
            next = current;
        }
        return next[0];
    }

}
