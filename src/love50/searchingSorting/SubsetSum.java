package love50.searchingSorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3};
        int r1 = -1;
        int r2 = 2;

        List<Integer> firstHalf = new ArrayList<>();
        getSubsequence(arr, arr.length / 2, 0, firstHalf, 0);
        Collections.sort(firstHalf);
        List<Integer> secondHalf = new ArrayList<>();
        getSubsequence(arr, arr.length, arr.length / 2, secondHalf, 0);
        Collections.sort(secondHalf);
        System.out.println(firstHalf);
        System.out.println(secondHalf);
        int result = 0;
        for(int i = 0; i < firstHalf.size(); i++) {
            int lower = r1 - firstHalf.get(i);
            int upper = r2 - firstHalf.get(i);

            int lowerBound = getLowerBound(lower, secondHalf);
            int upperBound = getUpperBound(upper, secondHalf);
            result += upperBound - lowerBound;
        }

        System.out.println(result);
    }

    private static int getUpperBound(int upper, List<Integer> arr) {
        int s = 0;
        int end = arr.size();

        while(s < end) {
            int mid = s + (end - s) / 2;
            if(arr.get(mid) <= upper) {
                s = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return s;
    }

    private static int getLowerBound(int lower, List<Integer> arr) {
        int s = 0;
        int end = arr.size();

        while(s < end) {
            int mid = s + (end - s) / 2;
            if(arr.get(mid) < lower) {
                s = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return s;
    }

    private static void getSubsequence(int[] arr, int n, int ind, List<Integer> result, int sum) {
        if(ind == n) {
            result.add(sum);
            return;
        }

        getSubsequence(arr, n, ind + 1, result, sum + arr[ind]);
        getSubsequence(arr, n, ind + 1, result, sum);
    }
}
