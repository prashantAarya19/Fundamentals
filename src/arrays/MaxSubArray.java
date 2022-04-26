package arrays;

public class MaxSubArray {

    public static int maxSubArray(int[] arr) {
        int currentMax= 0;
        int existingMax = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            currentMax += arr[i];

            if(existingMax < currentMax) {
                existingMax = currentMax;
            }

            if(currentMax < 0) {
                currentMax = 0;
            }
        }
        return existingMax;
    }
}
