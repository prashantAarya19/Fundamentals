package patterns;

/*
A
B C
C D E
D E F G
 */
public class Pattern10 {

    public static void main(String[] args) {
        printPattern(4);
        System.out.println();
        printPattern2(4);
    }

    public static void printPattern(int input) {
        int row = 1;
        char c = 'A';
        while(row <= input) {
            int col = 0;

            while(col < row) {
                char temp = (char)(c+col);
                System.out.print(temp+" ");
                ++col;
            }
            System.out.println();
            ++c;
            ++row;
        }
    }

    public static void printPattern2(int input) {
        int row = 1;

        while(row <= input) {
            int col = 1;

            while(col <= row) {
                char c = (char)('A'+ col + row - 2);
                System.out.print(c+" ");
                ++col;
            }
            System.out.println();
            ++row;
        }

    }
}
