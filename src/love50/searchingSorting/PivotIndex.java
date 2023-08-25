package love50.searchingSorting;

import java.util.HashMap;
import java.util.Map;

public class PivotIndex {
    public static int pivotIndex(int[] nums) {
        // Initialize total sum of the given array...
        int totalSum = 0;
        // Initialize 'leftsum' as sum of first i numbers, not including nums[i]...
        int leftsum = 0;
        // Traverse the elements and add them to store the totalSum...
        for (int ele : nums)
            totalSum += ele;
        // Again traverse all the elements through the for loop and store the sum of i numbers from left to right...
        for (int i = 0; i < nums.length; leftsum += nums[i++])
            // sum to the left == leftsum.
            // sum to the right === totalSum - leftsum - nums[i]..
            // check if leftsum == totalSum - leftsum - nums[i]...
            if (leftsum * 2 == totalSum - nums[i])
                return i;       // Return the pivot index...
        return -1;      // If there is no index that satisfies the conditions in the problem statement...
    }

    public static int pivotIndex2(int[] arr) {
        Map<Long, Integer> map = new HashMap<>();
        long totalSum = 0;
        for(int i = 0; i < arr.length; totalSum += arr[i++]) {
            map.putIfAbsent(2 * totalSum + arr[i], i);
        }

        return map.getOrDefault(totalSum, -1);
    }

    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};
        System.out.println(pivotIndex2(arr));
    }
}
