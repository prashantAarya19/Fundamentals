package thread;

public class UsingRunnable implements Runnable{
    public void printText() {
        System.out.println("Printing text");
    }
    @Override
    public void run() {
        System.out.println("Inside run method");
        printText();
    }

    public static void main(String[] args) {
        UsingRunnable a = new UsingRunnable();
        Thread t1 = new Thread(a);
        t1.start();
    }
}
