package patterns;

/*
****
***
**
*
 */

public class Pattern13 {
    public static void main(String[] args) {
        printPattern(4);
    }

    public static void printPattern(int input) {
        int row = input;

        while(row >= 1) {
            int col = 1;

            while(col <= row) {
                System.out.print("*");
                ++col;
            }
            System.out.println();
            --row;
        }
    }
}
