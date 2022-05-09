package recursion;

public class PowerOfNumber {
    public static void main(String[] args) {
        System.out.println(findPower(2, 8));
    }

    private static int findPower(int i, int n) {
        if(n == 0) {
            return 1;
        }

        return i*findPower(i, n-1);
    }
}
