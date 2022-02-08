package patterns;

/*
A B C
B C D
E F G
 */
public class Pattern9 {
    public static void main(String[] args) {
        printPattern(3);
    }

    public static void printPattern(int input) {
        int row = 1;
        char c = 'A';
        while(row <= input) {
            int col = 0;

            while(col < input) {
                char temp = c;
                temp = (char)(temp+col);
                System.out.print(temp+" ");
                ++col;
            }
            System.out.println();
            ++c;
            ++row;
        }
    }
}
