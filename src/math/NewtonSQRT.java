package math;

public class NewtonSQRT {
    public static double squareRoot(double n) {
        double a = n;

        double root;
        while(true) {
            root = 0.5 * (a + (n/a));
            if(Math.abs(root - a) < 0.1) {
                break;
            }
            a = root;
        }
        return root;
    }

    public static void main(String[] args) {
        //System.out.println((int)squareRoot(7&1));
    }
}
