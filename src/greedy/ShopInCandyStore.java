package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopInCandyStore {
    static ArrayList<Integer> candyStore(int[] candies, int N, int K){
        ArrayList<Integer> result = new ArrayList<>();

        Arrays.sort(candies);

        // get min amount
        result.add(getMinAmount(candies, K));
        result.add(getMaxAmount(candies, K));
        return result;
    }

    static int getMinAmount(int[] candies, int k) {
        int s = 0;
        int end = candies.length - 1;
        int minAmount = 0;
        while(s <= end) {
            minAmount += candies[s++];
            end = end - k;
        }
        return minAmount;
    }

    static int getMaxAmount(int[] candies, int k) {
        int s = 0;
        int end = candies.length - 1;
        int maxAmount = 0;
        while(s <= end) {
            maxAmount += candies[end--];
            s = s + k;
        }
        return maxAmount;
    }

}
