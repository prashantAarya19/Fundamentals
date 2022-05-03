package math;

public class FindGCD {

    public static int findGCD(int a, int b) {

        if(a == 0) {
            return b;
        }
        if(b == 0) {
            return a;
        }

        while(a != b) {

            if(a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(findGCD(72, 30));
    }
}
