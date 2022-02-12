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
            int increasingNumber = printIncreasingNumber(row);
            printDecreasingNumber(increasingNumber);
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

    public static int printIncreasingNumber(int input) {
        int incrementCounter = 1;

        while(incrementCounter <= input) {
            System.out.print(incrementCounter+" ");
            ++incrementCounter;
        }

        return --incrementCounter;
    }

    public static void printDecreasingNumber(int input) {
        int decrementCounter = input - 1;

        while(decrementCounter >= 1) {
            System.out.print(decrementCounter+" ");
            --decrementCounter;
        }
    }
}
