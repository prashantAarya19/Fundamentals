package recursion.practice;

public class FactorialOfNumber {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(solve(n));
        System.out.println(solve2(n, 1));
    }

    private static int solve(int n) {
        if(n == 0)
            return 1;
        int factorial = n * solve(n - 1);
        return factorial;
    }

    private static int solve2(int n, int factorial) {
        if(n == 0)
            return factorial;
        factorial = solve2(n - 1, factorial * n);
        return factorial;
    }
}
