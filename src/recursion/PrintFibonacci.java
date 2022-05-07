package recursion;

public class PrintFibonacci {
    public static void main(String[] args) {
        int n = 5;

        for(int i = 0; i <= n; i++) {
            System.out.print(printFib(i)+" ");
        }
    }

    private static int  printFib(int i) {
        if(i == 0) {
            return 0;
        }
        if(i >= 1 && i <= 2) {
            return 1;
        }

        return printFib(i - 1) + printFib(i - 2);
    }
}
