package dp;

import java.util.Arrays;

public class FibonacciSeries {
    public static int getFibonacciSeries(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        return getFibonacciSeries(n - 1) + getFibonacciSeries(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;

        for(int i = 0; i < n; i++) {
            System.out.print(getFibonacciSeries(i)+" ");
        }
        System.out.println();
        // get Fibonacci using memo
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        for(int i = 0; i < n; i++) {
            System.out.print(getFibonacciDynamic(i, memo)+" ");
        }

        System.out.println();
        // get Fibonacci using tabulation
        for(int i = 0; i < n; i++) {
//            System.out.print(getFibonacciTabulation(i)+" ");
            System.out.print(getFibonacciTabulationOptimize(i)+" ");
        }
    }

    // Top down
    public static int getFibonacciDynamic(int n, int[] memo) {
        if(n == 0 || n == 1)
            return n;

        if(memo[n] != -1)
            return memo[n];

        memo[n] = getFibonacciDynamic(n - 1, memo) + getFibonacciDynamic(n - 2, memo);
        return memo[n];
    }

    // Bottom up
    public static int getFibonacciTabulation(int n) {
        int[] tab = new int[n+1];
        tab[0] = 0;
        if(n >= 1)
            tab[1] = 1;

        for(int i = 2; i <= n; i++) {
            tab[i] = tab[i - 1] + tab[i - 2];
        }
        return tab[n];
    }

    // Memory optimizaion
    public static int getFibonacciTabulationOptimize(int n) {
        int next = 1;
        int previous = 0;

        if(n == 0)
            return previous;
        for(int i = 2; i <= n; i++) {
            int current = next + previous;
            previous = next;
            next = current;
        }
        return next;
    }
}
