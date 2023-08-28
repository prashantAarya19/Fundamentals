package love50.searchingSorting;

import util.Utility;

public class GapAlgo {
    public static void main(String[] args) {
        int[] arr1 = {2, 6, 8, 10};
        int[] arr2 = {1, 3, 9};
        Utility.printArray(arr1);
        Utility.printArray(arr2);

        int n = arr1.length;
        int m = arr2.length;

        int totalLength = n + m;
        int gap = totalLength / 2 + totalLength % 2;

        while(gap > 0) {
            int left = 0;
            int right = gap + left;

            while(right < totalLength) {

                if(left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                } else if(right >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                } else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }

            if(gap == 1)
                break;
            else
                gap = gap / 2 + gap % 2;
        }

        Utility.printArray(arr1);
        Utility.printArray(arr2);
    }

    private static void swapIfGreater(int[] arr1, int[] arr2, int ind1, int ind2) {
        if(arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }
}
