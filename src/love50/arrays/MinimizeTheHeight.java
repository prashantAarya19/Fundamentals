package love50.arrays;

import java.util.Arrays;

public class MinimizeTheHeight {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);

        int min = 0;
        int max = 0;
        int result = arr[n - 1] - arr[0];

        for(int i = 1; i < n; i++) {
            if(arr[i] - k < 0)
                continue;

            min = Math.min(arr[0] + k, arr[i] - k);
            max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            result = Math.min(result, max - min);
        }
        return result;
    }
}
