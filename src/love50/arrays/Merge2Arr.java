package love50.arrays;

import java.util.Arrays;

public class Merge2Arr {
    public static void mergeO2(long arr1[], long arr2[], int n, int m)
    {
        for(int i2 = m - 1; i2 >= 0; i2--) {
            long lastElmOfArr1 = arr1[n - 1];
            int i1;
            for(i1 = n - 2; i1 >= 0 && arr1[i1] > arr2[i2]; i1--) {
                arr1[i1 + 1] = arr1[i1];
            }

            if(lastElmOfArr1 > arr2[i2]) {
                arr1[i1 + 1] = arr2[i2];
                arr2[i2] = lastElmOfArr1;
            }
        }
    }

    // TC:  O((n+m) log(n+m))
    public static void mergeOptimized(long arr1[], long arr2[], int n, int m) {
        int s1 = 0;
        int s2 = 0;
        int lastI = n - 1;

        while(s1 <= lastI && s2 < m) {
            if(arr1[s1] < arr2[s2]) {
                s1++;
            } else {
                long temp = arr2[s2];
                arr2[s2] = arr1[lastI];
                arr1[lastI] = temp;
                s2++;
                lastI--;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
