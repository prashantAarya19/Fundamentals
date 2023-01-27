package love50.arrays;

public class KadensAlgo {
    long maxSubarraySum(int[] arr, int n){
        return solve(arr, n);
    }

    long solve(int[] arr, int n) {

        long currentMax = 0;
        long prevMax = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            currentMax += arr[i];
            if(currentMax > prevMax) {
                prevMax = currentMax;
            }
            if(currentMax < 0) {
                currentMax = 0;
            }
        }

        return prevMax;

    }

}
