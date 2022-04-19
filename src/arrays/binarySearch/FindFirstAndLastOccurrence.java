package arrays.binarySearch;

import java.util.ArrayList;

public class FindFirstAndLastOccurrence {

    public static int findFirstOccurrence(int[] arr, int k) {
        int s = 0;
        int e = arr.length-1;
        int mid = s+(e-s)/2;
        int result = -1;
        while(s <= e) {
            if(k == arr[mid]) {
               result = mid;
               e = mid - 1;
            } else if(k > arr[mid]) {
                s = mid+1;
            } else {
                e = mid-1;
            }
            mid = s+(e-s)/2;
        }
        return result;
    }

    public static int findLastOccurrence(int[] arr, int k) {
        int s = 0;
        int e = arr.length-1;
        int mid = s+(e-s)/2;
        int result = -1;
        while(s<=e) {
            if(k == arr[mid]) {
                result = mid;
                s = mid+1;
            } else if(k > arr[mid]) {
                s = mid+1;
            } else {
                e = mid-1;
            }
            mid = s+(e-s)/2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 2, 2, 3, 3};
        System.out.println(findLastOccurrence(arr, 0));
    }

}
