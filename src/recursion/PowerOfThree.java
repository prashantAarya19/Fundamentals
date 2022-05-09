package recursion;

public class PowerOfThree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThreeRecursive(4));
    }

    private static boolean isPowerOfThree(int i) {
        if(i < 1) {
            return false;
        }

        while(i%3 == 0) {
            i /= 3;
        }

        return i == 1;
    }

    private static boolean isPowerOfThreeRecursive(int i) {
        if(i < 1)
            return false;
        if(i == 1)
            return true;
        if(i % 3 != 0)
            return false;

        return isPowerOfThreeRecursive(i/3);
    }
}
