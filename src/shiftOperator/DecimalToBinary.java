package shiftOperator;

public class DecimalToBinary {

    public static void main(String[] args) {
        System.out.println(decimalToBinary(5));
    }

    public static int decimalToBinary(int input) {
        int b;
        int ans = 0;
        int counter = 0;
        while(input != 0) {
            // for getting the first digit
            b = (byte)(input&1);
            // reversing the bits
            ans = (int)(Math.pow(10, counter)*b)+ans;
            // right shift divide the input by 2 or shift the bits by 1 towards right. So the bits at right will be gone
            input = input >> 1;
            ++counter;
        }
        return ans;
    }
}
