package math;

import java.util.Arrays;

public class CountPrime {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, Boolean.TRUE);
        if(n <= 2) {
            return count;
        }
        isPrime[0] = isPrime[1] = Boolean.FALSE;

        for(int i = 2; i < n; i++) {
            if(isPrime[i]) {
                ++count;
                for(int j = 2*i; j < isPrime.length; j = j+i) {
                    if(j%i == 0) {
                        isPrime[j] = Boolean.FALSE;
                    }
                }
            }
        }
        return count;
    }
}
