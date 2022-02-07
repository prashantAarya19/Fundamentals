package patterns;

/*
* * * *
* * * *
* * * *
* * * *
 */
public class Pattern1 {

    public static void main(String[] args) {
        int col = 0;

        while(col < 4) {
            int row = 0;
            while(row < 4) {
                System.out.print("* ");
                row++;
            }
            System.out.println();
            col++;
        }
    }

}
