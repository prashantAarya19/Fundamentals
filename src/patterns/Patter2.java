package patterns;

/*
1 1 1 1
2 2 2 2
3 3 3 3
 */
public class Patter2 {

    public static void main(String[] args) {
        int row = 1;

        while(row <= 3) {
            int col = 1;
            while(col <= 4) {
                System.out.print(row+" ");
                ++col;
            }
            System.out.println();
            ++row;
        }
    }
}
