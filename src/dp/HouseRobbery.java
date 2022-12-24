package dp;

import java.util.ArrayList;
import java.util.List;

public class HouseRobbery {
    public static long houseRobber(int[] valueInHouse) {
        int n = valueInHouse.length;
        if(n == 1)
            return valueInHouse[0];
        List<Integer> excludeFirst = new ArrayList<>();
        List<Integer> excludeLast = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(i < n - 1)
                excludeLast.add(valueInHouse[i]);
            if(i > 0)
                excludeFirst.add(valueInHouse[i]);
        }

        return Long.max(getMaxSum(excludeFirst), getMaxSum(excludeLast));

    }

    public static long getMaxSum(List<Integer> valueInHouse) {
        long prev1 = valueInHouse.get(0);
        long prev2 = 0;

        for(int i = 1; i < valueInHouse.size(); i++) {
            long include = prev2 + valueInHouse.get(i);
            long exclude = prev1;

            long result = Long.max(include, exclude);
            prev2 = prev1;
            prev1 = result;
        }
        return prev1;
    }
}
