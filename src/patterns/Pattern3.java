package patterns;

/*
* * * *
* * *
* *
*
 */
public class Pattern3 {
    public static void main(String[] args) {
        int row = 0;

        while(row < 4) {
            int col = 4;
            while(col > row) {
                System.out.print("* ");
                --col;
            }
            System.out.println();
            ++row;
        }
    }
}
