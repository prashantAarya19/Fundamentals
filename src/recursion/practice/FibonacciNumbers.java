package recursion.practice;

public class FibonacciNumbers {
    public static void main(String[] args) {
        int n = 4; // 0 1 1 2 3
        solve(4);
    }

    private static int solve(int i) {
        if(i <= 1) {
            return i;
        }

        int fib = solve(i - 2) + solve(i - 1);
        System.out.print(fib + " ");
        return fib;
    }
}
