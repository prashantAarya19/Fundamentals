package patterns;

/*
D
C D
B C D
A B C D
 */
public class Pattern11 {
    public static void main(String[] args) {
        printPattern(4);
    }

    public static void printPattern(int input) {
        int row = 1;

        while(row <= input) {
            int col = 1;

            while(col <= row) {
                char c = (char)('D'-row+col);
                System.out.print(c+" ");
                ++col;
            }
            System.out.println();
            ++row;
        }
    }
}
