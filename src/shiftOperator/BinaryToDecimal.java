package shiftOperator;

public class BinaryToDecimal {
    public static void main(String[] args) {
        System.out.println(binaryToDecimal(1100));
    }

    public static int binaryToDecimal(int input) {
        int result = 0;
        int counter = 0;
        int b;
        while(input != 0) {
            b = input % 10;
            if(b == 1) {
                result = result + (int) Math.pow(2, counter);
            }
            input = input/10;
            ++counter;
        }
        return result;
    }
}
