package arrays.binarySearch.problems;

import java.util.HashMap;
import java.util.Map;

public class CapacityShip {

        public static boolean isPossibleWeight(int[] weights, int days, int midWeight) {
            int daysCount = 1;
            int weightSum = 0;

            for(int i = 0; i < weights.length; i++) {
                if(weightSum+weights[i] <= midWeight) {
                    weightSum += weights[i];
                } else {
                    daysCount++;
                    if(daysCount > days || weights[i] > midWeight) {
                        return false;
                    }
                    weightSum = weights[i];
                }
            }
            return true;
        }
        public static int shipWithinDays(int[] weights, int days) {
            //contiguous location
            int minWeight = 0;
            int maxWeight = 0;
            int result = -1;

            for(int i = 0; i < weights.length; i++) {
                maxWeight += weights[i];
            }
            int midWeight = minWeight + (maxWeight - minWeight)/2;

            while(minWeight <= maxWeight) {
                if(isPossibleWeight(weights, days, midWeight)) {
                    result = midWeight;
                    maxWeight = midWeight-1;
                } else {
                    minWeight = midWeight + 1;
                }
                midWeight = minWeight + (maxWeight - minWeight)/2;
            }

            return result;
        }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        System.out.println(shipWithinDays(arr, 2));
    }
}
