package numbers;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(153423646));
    }

    public static int reverse(int x) {
        int MAX_INT = Integer.MAX_VALUE;
        int MIN_INT = Integer.MIN_VALUE;
        int result = 0;
        while(x != 0) {
            int lastDigit = x%10;
            if(result > MAX_INT/10 || result < MIN_INT/10) {
                return  0;
            }
            result = (result*10)+lastDigit;
            x = x/10;
        }
        return result;
    }

}
