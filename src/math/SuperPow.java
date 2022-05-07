package math;

import java.util.ArrayList;

public class SuperPow {
    public static int superPow(int a, int[] b) {
        int power = 0;
        int mod = 1337;
        for(int i = 0; i < b.length; i++) {
            power = (power*10)+b[i];
        }
        System.out.println("Power::"+power);

        int result = 1;
        while(power > 0) {

            if(power%2 == 1) {
                System.out.println("Inside odd result :"+result);
                result = result*a;
            }

            a = a*a;

            power = power>>1;
        }
        return result;
    }
    public static void main(String[] args) {
        int i = 2;
        System.out.println(superPow(i, new int[]{1,0}));

    }
}
