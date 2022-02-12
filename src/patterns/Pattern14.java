package patterns;

/*
   1
  1 2 1
 1 2 3 2 1
1 2 3 4 3 2 1

 */

public class Pattern14 {

    public static void main(String[] args) {
        printPattern(4);
    }

    public static void printPattern(int input) {
        int row = 1;

        while(row <= input) {
            int counter = input - row;
            printSpace(counter);
            printIncreasingNumber(row);
            printDecreasingNumber(row);
            System.out.println();
            ++row;
        }

    }

    public static void printSpace(int input) {
        int spaceCounter = 1;
        while(spaceCounter <= input) {
            System.out.print(" ");
            ++spaceCounter;
        }
    }

    public static void printIncreasingNumber(int input) {
        int incrementCounter = 1;

        while(incrementCounter <= input) {
            System.out.print(incrementCounter+" ");
            ++incrementCounter;
        }
    }

    public static void printDecreasingNumber(int input) {
        int decrementCounter = input - 1;

        while(decrementCounter > 0) {
            System.out.print(decrementCounter+" ");
            --decrementCounter;
        }
    }
}
