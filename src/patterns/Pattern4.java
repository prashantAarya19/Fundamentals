package patterns;

/*
1 2 3
4 5 6
7 8 9
 */
public class Pattern4 {

    public static void main(String[] args) {

        // Solution 1
        int row = 0;
        int col = 1;
        while(row < 3) {
            int temp = col;
            while(col < temp+3) {
                System.out.print(col+" ");
                ++col;
            }
            System.out.println();
            ++row;
        }

        System.out.println();

        printPattern();
    }

    // Solution 2
    public static void printPattern() {
        int row = 1;
        int count = 1;

        while(row <= 3) {
            int col = 1;
            while(col <= 3) {
                System.out.print(count++ +" ");
                ++col;
            }
            System.out.println();
            ++row;
        }
    }
}
