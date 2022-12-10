package dp;

import java.util.* ;

public class DistinctWayToClimbStairs {
    static long modulo = 1000000000l + 7l;
	public static int countDistinctWayToClimbStair(long nStairs) {
        long[] memo = new long[(int)nStairs + 1];
        Arrays.fill(memo, -1l);
		return (int)((solve(nStairs, 0, memo))% modulo);
	}
    
    private static long solve(long stairs, int start, long[] memo) {
        if(start == (int)stairs)
            return 1l;
        
        if(start > (int)stairs)
            return 0l;
        
        if(memo[start] != -1l)
            return memo[start];
        
        memo[start] = (solve(stairs, start + 1, memo) + solve(stairs, start + 2, memo))%modulo;
        return memo[start];
    }
}