package arrays.mergeSort;

import java.util.Arrays;

public class MSort {
    public static void main(String[] args) {
        int[] arr = {9, 4, 11, 3, 6, 45, 84, 33};
         sortMergeInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    // It's not in place algorithm
    public static int[] sortMerge(int[] arr) {
        if(arr.length == 1) {
            return arr;
        }
        int mid = arr.length/2;
        int[] left = sortMerge(Arrays.copyOfRange(arr, 0, mid));
        int[] right = sortMerge(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int s1 = 0, s2 = 0;
        int e1 = left.length, e2 = right.length;

        int[] tempArr = new int[left.length + right.length];
        int tempIndex = 0;
        while(s1 < e1 && s2 < e2) {
            tempArr[tempIndex++] = left[s1] < right[s2] ? left[s1++] : right[s2++];
        }

        while(s1 < e1) {
            tempArr[tempIndex++] = left[s1++];
        }

        while(s2 < e2) {
            tempArr[tempIndex++] = right[s2++];
        }
        return tempArr;
    }

    // It's in place algorithm
    public static void sortMergeInPlace(int[] arr, int s, int e) {
        if(e - s == 1) {
            return;
        }
        int mid = s + (e-s)/2;
        sortMergeInPlace(arr, s, mid);
        sortMergeInPlace(arr, mid, e);
        mergeInPlace(arr, s, mid, e);
    }

    public static void mergeInPlace(int[] arr, int s, int mid, int e) {
        int s1 = s;
        int s2 = mid;

        int[] tempArr = new int[e - s];
        int tempIndex = 0;
        while(s1 < mid && s2 < e) {
            tempArr[tempIndex++] = arr[s1] < arr[s2]  ? arr[s1++] : arr[s2++];
        }

        while(s1 < mid) {
            tempArr[tempIndex++] = arr[s1++];
        }

        while(s2 < e) {
            tempArr[tempIndex++] = arr[s2++];
        }

      //  System.out.println("Temp : "+Arrays.toString(arr)+" \n");

        System.arraycopy(tempArr, 0, arr, s, tempArr.length);
    }
}