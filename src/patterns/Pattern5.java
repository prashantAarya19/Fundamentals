package patterns;

/*
1
2 1
3 2 1
 */

import java.util.Scanner;

public class Pattern5 {

    public static void main(String[] args) {
        int input;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input:: ");
        input = sc.nextInt();
        printPatter1(input);
        printPatter2(input);
    }

    public static void printPatter1(int input) {
        int row = 1;

        while(row <= input) {
            int col = row;
            while(col > 0) {
                System.out.print(col+" ");
                --col;
            }
            System.out.println();
            ++row;
        }

    }

    public static void printPatter2(int input) {
        int row = 1;

        while(row <= input) {
            int col = 1;

            while(col <= row) {
                System.out.print(row - col + 1 +" ");
                ++col;
            }
            System.out.println();
            ++row;
        }
    }
}
