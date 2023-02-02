package love50.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairCount {
    int getPairsCount(int[] arr, int n, int k) {
        return solve2(arr, n, k);
    }

    private int solve2(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            int key = k - arr[i];
            if(map.containsKey(key)) {
                count += map.get(key);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }

    private int solve(int[] arr, int n, int k) {
        int count = 0;
        Arrays.sort(arr);
        for(int i = 0; i < n; i++) {
            int key = k - arr[i];

            int lowerBound = getLowerBound(arr, i + 1, n, key);
            int upperBound = getUpperBound(arr, i + 1, n, key);

            count += (upperBound - lowerBound);
        }
        return count;
    }

    private int getLowerBound(int[] arr, int start, int end, int key) {
        int s = start;
        int e = end;

        while(s < e) {
            int mid = s + (e - s)/2;

            if(arr[mid] < key) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }

    private int getUpperBound(int[] arr, int start, int end, int key) {
        int s = start;
        int e = end;

        while(s < e) {
            int mid = s + (e - s)/2;
            if(arr[mid] <= key) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }
}
