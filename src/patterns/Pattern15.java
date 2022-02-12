package patterns;
/*
1 2 3 4 5 5 4 3 2 1
1 2 3 4 * * 4 3 2 1
1 2 3 * * * * 3 2 1
1 2 * * * * * * 2 1
1 * * * * * * * * 1
 */
public class Pattern15 {
    public static void main(String[] args) {
        printPattern(5);
    }

    public static void printPattern(int input) {
        int row = 1;

        while(row <= input) {
            printIncreasingNumber(input - row + 1);
            printStar(row);
            printDecreasingNumber(input - row + 1);
            System.out.println();
            ++row;
        }
    }

    public static void printIncreasingNumber(int input) {
        int increasingCounter = 1;
        while(increasingCounter <= input) {
            System.out.print(increasingCounter+" ");
            ++increasingCounter;
        }
    }

    public static void printStar(int input) {
        if(input < 2) {
            return;
        }

        int starCounter = 1;
        while(starCounter <= (input-1)*2) {
            System.out.print("* ");
            ++starCounter;
        }
    }

    public static void printDecreasingNumber(int input) {
        int decreasingCounter = input;

        while (decreasingCounter > 0) {
            System.out.print(decreasingCounter+" ");
            --decreasingCounter;
        }
    }
}

