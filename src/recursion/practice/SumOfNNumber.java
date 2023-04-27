package recursion.practice;

public class SumOfNNumber {
    public static void main(String[] args) {
        int n = 5; // 1 + 2 + 3 + 4 + 5 = 15
        System.out.println(solve(n));
        System.out.println(solve2(n, 0));
    }

    private static int solve(int n) {
        if(n == 0)
            return 0;
        int result = n + solve(n - 1);
        return result;
    }

    private static int solve2(int n, int sum) {
        if(n == 0)
            return sum;
        sum = solve2(n - 1, sum + n);
        return sum;
    }
}
