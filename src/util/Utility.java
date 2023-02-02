package util;

import java.util.Arrays;

public class Utility {
    public static void printArray(int[] arr) {
        Arrays.stream(arr)
                .forEach(elm -> System.out.print(elm +" "));

        System.out.println();
    }

    public static void printArray(long[] arr) {
        Arrays.stream(arr)
                .forEach(elm -> System.out.print(elm +" "));

        System.out.println();
    }

    public static int lowerBound(int[] arr, int start, int end, int key) {
        int s = start;
        int e = end;
        // {2, 3}; k = 1;
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

    public static int upperBound(int[] arr, int start, int end, int key) {
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
        return  s;
    }
}
