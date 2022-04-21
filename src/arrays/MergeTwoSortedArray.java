package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 4, 5, 0, 0, 0, 0}, arr2 = {2, 4, 6, 8};
        merge(arr1, arr2);
        Arrays.stream(arr1).forEach(e -> System.out.print(e +" "));
    }

    public static void merge(int[] arr1, int[] arr2) {
        int s1 = 0, s2 = 0;
        int e1 = 4, e2 = arr2.length;

        int[] mainArray = new int[e1+e2];
        int mainArrayIndex = 0;

        while(s1 < e1 && s2 < e2) {
            if(arr1[s1] < arr2[s2]) {
                mainArray[mainArrayIndex++] = arr1[s1++];
            } else {
                mainArray[mainArrayIndex++] = arr2[s2++];
            }
        }

        while(s1 < e1) {
            mainArray[mainArrayIndex++]= arr1[s1++];
        }

        while(s2 < e2) {
            mainArray[mainArrayIndex++] = arr2[s2++];
        }
    }
}
