package patterns;
/*
    *
  * *
* * *

 */
public class Pattern12 {

    public static void main(String[] args) {
        printPattern(5);
    }

    public static void printPattern(int input) {
        int row = 1;

        while(row <= input) {
            int col = input;
            while(col >= 1) {
                if(col <= row) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                --col;
            }
            System.out.println();
            ++row;
        }
    }
}
