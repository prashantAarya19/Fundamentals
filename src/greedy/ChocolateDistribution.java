package greedy;

import java.util.ArrayList;

public class ChocolateDistribution {
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // 3, 4, 1, 9, 56, 7, 9, 12
        // sort - 1 3 4 7 9 12 56
        // sort the array
        // diff 0 - m - 1
        // increase start and end till e < n;

        a.sort((e1, e2) -> Integer.compare(e1, e2));

        int s = 0;
        int e = m - 1;
        int minDiff = Integer.MAX_VALUE;

        while(e < n) {
            minDiff = Math.min(minDiff, a.get(e++) - a.get(s++));
        }
        return minDiff;
    }
}
