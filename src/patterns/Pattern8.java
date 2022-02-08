package patterns;

/*
A
A B
A B C
 */

public class Pattern8 {

    public static void main(String[] args) {
        printPattern(3);
    }

    public static void printPattern(int input) {
        int row = 1;

        while(row <= input) {
            int col = 0;
            while(col < row) {
                char c = (char)('A'+col);
                System.out.print(c+" ");
                ++col;
            }
            System.out.println();
            ++row;
        }

    }
}
