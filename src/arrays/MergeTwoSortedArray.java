package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedArray {

    public static void main(String[] args) {
        //int[] arr1 = { 1, 3, 4, 5, 0, 0, 0, 0}, arr2 = {2, 4, 6, 8};
        int[] arr1 = {4, 0}, arr2 = {2};
        merge(arr1, 1, arr2);
        Arrays.stream(arr1).forEach(e -> System.out.print(e +" "));
    }

    public static void merge(int[] arr1, int n, int[] arr2) {
        int s1 = 0, s2 = 0;
        int e2 = arr2.length;

        int[] mainArray = new int[n +e2];
        int mainArrayIndex = 0;

        while(s1 < n && s2 < e2) {
            if(arr1[s1] < arr2[s2]) {
                mainArray[mainArrayIndex++] = arr1[s1++];
            } else {
                mainArray[mainArrayIndex++] = arr2[s2++];
            }
        }

        while(s1 < n) {
            mainArray[mainArrayIndex++]= arr1[s1++];
        }

        while(s2 < e2) {
            mainArray[mainArrayIndex++] = arr2[s2++];
        }

        mainArrayIndex = 0;
        while(mainArrayIndex < arr1.length) {
            arr1[mainArrayIndex] = mainArray[mainArrayIndex];
            ++mainArrayIndex;
        }
    }
}
