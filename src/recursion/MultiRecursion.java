package recursion;

public class MultiRecursion {
    public static void printIt(int i) {
        if(i == 0)
            return;

        printIt(i/2);
        System.out.print(i+" ");
        printIt(i/2);
    }

    public static void main(String[] args) {
        printIt(10);
    }
}
