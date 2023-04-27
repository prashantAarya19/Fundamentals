package recursion.practice;

public class PrintNumberReverse {
    public static void main(String[] args) {
        int n = 10;
        solve(n, 1);
    }

    private static void solve(int n, int i) {
        if(i > n)
            return;

        solve(n, i + 1);
        System.out.println(i);
    }
}
