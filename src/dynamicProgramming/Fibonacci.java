package dynamicProgramming;

import java.util.HashMap;

public class Fibonacci {

    public static long getFib(int n) {
        // 1 1 2 3 5 8
        if(n <= 2) return 1;
        return getFib(n - 1)+getFib(n-2);
    }

    public static long getFibDynamic(int n) {
        HashMap<Integer, Long> memo = new HashMap<>();
        return getFibWithMemo(n, memo);
    }

    public static long getFibWithMemo(int n, HashMap<Integer, Long> memo) {
        if(memo.containsKey(n)) return memo.get(n);
        if(n <= 2) return 1;
        memo.put(n, getFibWithMemo(n-1, memo)+getFibWithMemo(n-2, memo));
        return memo.get(n);
    }

    public static void main(String[] args) {
        //System.out.println(getFib(6));
      //  System.out.println(getFib(50)); // this line took more than 45 sec
        System.out.println(getFibDynamic(50)); // this line took less than a second
    }
}
