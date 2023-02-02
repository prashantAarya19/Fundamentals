package love50.arrays;

public class NexPermutation {
    public void nextPermutation(int[] nums) {
        // 1. find the first non decreasing element
        // 2. find the element just greater than the pivot element
        // 3. swap the element
        // 4. reverse the suffix [1,1,5] [1,2,3]
        int n = nums.length;
        int pivotIndex = getPivot(nums, n) - 1;

        if(pivotIndex != -1) {
            int nextGreaterIndex = nextGreaterOfPivotIndex(nums, n, pivotIndex);
            swap(nums, pivotIndex, nextGreaterIndex);
        }
        reverseSuffix(nums, pivotIndex + 1, n);
    }



    private int getPivot(int[] nums, int n) {
        for(int i = n - 1; i > 0; i--) {
            if(nums[i - 1] < nums[i]) {
                return i;
            }
        }
        return 0;
    }

    private int nextGreaterOfPivotIndex(int[] nums, int n, int pivotIndex) {
        for(int i = n - 1; i >= 0; i--) {
            if(nums[i] > nums[pivotIndex]) {
                return i;
            }
        }
        return -1;
    }

    private void reverseSuffix(int[] nums, int pivotIndex, int n) {
        int s = pivotIndex;
        int e = n - 1;

        while(s < e) {
            swap(nums, s, e);
            s++;
            e--;
        }
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
