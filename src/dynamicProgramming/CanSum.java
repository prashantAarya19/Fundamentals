package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CanSum {
    public static boolean canSum(int targetSum, int[] arr) {
        if(targetSum == 0) return Boolean.TRUE;
        if(targetSum < 0) return Boolean.FALSE;

        for(int e : arr) {
            int diff = targetSum - e;
            if(canSum(diff, arr))
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    // DP method
    public static boolean canSumDynamic(int targetSum, int[] arr, Map<Integer, Boolean> memo) {
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0) return Boolean.TRUE;
        if(targetSum < 0) return Boolean.FALSE;

        for(int e : arr) {
            int diff = targetSum - e;
            memo.put(diff, canSumDynamic(diff, arr, memo));
            if(memo.get(diff))
                return Boolean.TRUE;
        }
        memo.put(targetSum, Boolean.FALSE);
        return Boolean.FALSE;
    }

    public static void main(String[] args) {
        int[] arr = {7, 14};
       // System.out.println(canSum(30000, arr)); // false // way slower than canSumDynamic
        System.out.println(canSumDynamic(30000, arr, new HashMap<>()));
        /*
                        21
           (21-4) (21-6) (21-2) (21-1)
          17        15       19     20
         (17-6)    (15-6)
        11           9
       (11-6)       (9-6)
      9              3
    (9-6)           (3-2)
   3                  1
  (3-2)              (1-1)
 1                     0
(1-1)
0

         */
    }
}
