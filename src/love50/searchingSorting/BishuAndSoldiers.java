package love50.searchingSorting;

import java.util.Arrays;

public class BishuAndSoldiers {
    public static void main(String[] args) {
        int[] soldiersPower = {1, 2, 3, 4, 5, 6, 7};
        int[] bishuPowers = {3, 10, 2};
        int n = 7;
        Arrays.sort(soldiersPower);
        int[] powerSum = new int[n + 1];
        for(int i = 1; i < n + 1; i++) {
            powerSum[i] = powerSum[i - 1] + soldiersPower[i - 1];
        }

        for(int i = 0; i < bishuPowers.length; i++) {
            int currentPower = bishuPowers[i];
            int upperBound = getUpperBound(soldiersPower, currentPower);
            System.out.println(upperBound + " " + powerSum[upperBound]);
        }

    }

    private static int getUpperBound(int[] arr, int key) {
        int s = 0;
        int e = arr.length;

        while(s < e) {
            int mid = s + (e - s) / 2;
            if(arr[mid] <= key) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }

        return s;
    }
}
