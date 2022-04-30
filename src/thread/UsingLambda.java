package thread;

public class UsingLambda {
    public static void printSomething() {
        System.out.println("Printing something");
    }

    public static void main(String[] args) {
        //UsingLambda a = new UsingLambda();
        Thread t = new Thread(UsingLambda::printSomething);
        t.start();
    }
}
