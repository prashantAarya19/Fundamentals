package dp;

import java.util.HashMap;
import java.util.Map;

public class LongestAPWitDiff {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int maxCount = 0;
        for(int i = 0; i < arr.length; i++) {
            int diff = arr[i] - difference; // a - b = diff, a - diff = b;
            int tempCount = 0;

            if(dp.containsKey(diff))
                tempCount =  dp.get(diff);

            dp.put(arr[i], tempCount + 1);

            maxCount = Math.max(maxCount, dp.get(arr[i]));
        }
        return maxCount;
    }
}
