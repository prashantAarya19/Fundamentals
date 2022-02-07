package patterns;

/*
A A A
B B B
C C C
 */

import java.util.Scanner;

//** Hint **//
// A = 65, a = 97
public class Pattern6 {

    public static void main(String[] args) {
        char letter = 65;
        int input;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input::");
        input = sc.nextInt();

        int row = 1;

        while (row <= input) {
            int column = 1;

            do {
                System.out.print(letter+" ");
                ++column;
            } while (column <= input);

            System.out.println();
            ++letter;
            ++row;
        }

    }
}
