package dynamicProgramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridTraveler {

    // n and m denotes the row and column of grid
    public static int getNumberOfWays(int n, int m) {
        if(n == 1 && m == 1) return 1;
        if(n == 0 || m == 0) return 0;
        return getNumberOfWays(n-1, m)+getNumberOfWays(n, m-1);
    }

    //dynamic programming solution
    public static long getNumberOfWaysDynamic(int n, int m, Map<String, Long> memo) {
        String key = n+"_"+m;
        // Base cases
        if(memo.containsKey(key)) return memo.get(key);
        if(n == 1 && m == 1) return 1;
        if(n == 0 || m == 0) return 0;

        memo.put(key, getNumberOfWaysDynamic(n-1, m, memo)+getNumberOfWaysDynamic(n, m-1, memo));
        return memo.get(key);
    }

    public static void main(String[] args) {
        System.out.println(getNumberOfWays(100,100)); // Took more than 10 minutes. Didn't get result.
       // System.out.println(getNumberOfWaysDynamic(100,100, new HashMap<>())); // result in 2 sec.
    }
}
