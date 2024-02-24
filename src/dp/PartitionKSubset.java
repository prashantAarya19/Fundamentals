package dp;

public class PartitionKSubset {
    public static void main(String[] args) {
        int arr[] = { 2, 1, 4, 5, 3, 3 };
        int n = arr.length;
        int k = 3;
        //System.out.println(isKPartitionPossible(arr, n, k));
        int a = 3;
        int mask = 1 << 0;
        System.out.println(mask);
        mask = ~mask;
        System.out.println(a & mask);
    }

    static boolean isKPartitionPossible(int arr[], int N, int K) {
        if (K == 1) return true;
        if (N < K)
            return false;

        int sum = 0;
        for (int i = 0; i < N; i++)
            sum += arr[i];

        if (sum % K != 0)
            return false;

        int target = sum / K;

        // Initialize dp array with -1
        int[] dp = new int[(1 << 15)];
        for (int i = 0; i < (1 << N); i++)
            dp[i] = -1;

        // Sum of empty subset
        // is zero
        dp[0] = 0;

        // Iterate over all subsets/masks
        for (int mask = 0; mask < (1 << N); mask++) {

            // if current mask is invalid, continue
            if (dp[mask] == -1)
                continue;

            // Iterate over all array elements
            for (int i = 0; i < N; i++) {

                // Check if the current element
                // can be added to the current
                // subset/mask
                if (((mask & (1 << i)) == 0) &&
                        dp[mask] + arr[i] <= target) {

                    // Transition
                    dp[mask | (1 << i)] = (dp[mask] +
                            arr[i]) %
                            target;
                }
            }
        }

        if (dp[(1 << N) - 1] == 0)
            return true;
        else
            return false;
    }
}
