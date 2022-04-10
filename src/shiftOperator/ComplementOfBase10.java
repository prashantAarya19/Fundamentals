package shiftOperator;

public class ComplementOfBase10 {
    public static int decimalToBinary(int input) {
        int result = 0;
        int counter = 0;

        while(input != 0) {
            int b = (byte)input&1;
            result = (int) (Math.pow(10, counter)*b)+result;
            input = input >> 1;
            counter++;
        }
        return result;
    }

    public static int invertBits(int input) {
        return ~input;
    }

    public static int getMask(int input) {
        int mask = 0;
        while (input != 0) {
            mask = (mask << 1) | 1;
            input = input >> 1;
        }
        return mask;
    }

    public static int binaryToDecimal(int input) {
        int result = 0;
        int counter = 0;
        while (input != 0) {
            int lastDigit = input % 10;
            if(lastDigit != 0) {
                result = (int) (Math.pow(2, counter)) + result;
            }
            input = input/10;
            ++counter;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 5;
        System.out.println(invertBits(a)&getMask(a));
    }
}
