package arrays;

import java.util.*;

public class TripletSum {
    public static void main(String[] args) {
        int[] arr = {4,3,2,3,5,2,1};
        int n = 7;
        System.out.println(1<<arr.length);

    }

    private static boolean isTriplateSum(Integer[] nums, int k) {
        Arrays.sort(nums);
        int mid = 0, end = 0;
        for(int s = 0; s < nums.length; s++) {
            mid = s + 1;
            end = nums.length - 1;

            while(mid < end) {
                int sum = nums[s] + nums[mid] + nums[end];
                if(sum == k)
                    return true;
                else if(sum < k)
                    mid++;
                else
                    end--;
            }

        }
        return false;
    }

    private static boolean triplateSum2(int[] arr, int k) {
        for(int i = 0; i < arr.length; i++) {
            Set<Integer> set = new HashSet<>();
            int currentSum = k - arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                if(set.contains(currentSum - arr[j]))
                    return true;
                else
                    set.add(arr[j]);
            }
        }
        return false;
    }
}