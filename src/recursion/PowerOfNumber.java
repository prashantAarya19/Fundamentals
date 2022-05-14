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

    private static int findPower2(int i, int n) {
        if(n == 0) {
            return 1;
        }

//        if(n%2 == 0) {
//            return findPower2(i, n/2)*findPower(i, n/2);
//        } else {
//            return findPower2(i, n/2)*findPower(i, n/2)*i;
//        }

        // Optimization
        int result = findPower2(i, n/2);

        if(n%2 == 0)
            result = result*result;
        else
            result = i*result*result;

        return result;

    }
}
