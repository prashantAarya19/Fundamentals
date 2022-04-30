package thread;

public class ExtendingThread extends Thread{
    public void printText() {
        System.out.println("Printing text");
    }

    @Override
    public void run() {
        System.out.println("Inside run");
        printText();
    }

    public static void main(String[] args) {
        ExtendingThread a = new ExtendingThread();
        a.start();
    }
}
