package patterns;
/*
A
B A
C B A
 */
public class Pattern7 {
    public static void main(String[] args) {
        pattern1(3);
    }

    public static void pattern1(int input) {
        int row = 1;

        while(row <= input) {
            int column = 1;

            while(column <= row) {
                char c = (char)('A'+ row - column);
                System.out.print(c+" ");
                ++column;
            }
            System.out.println();
            ++row;
        }
    }
}
