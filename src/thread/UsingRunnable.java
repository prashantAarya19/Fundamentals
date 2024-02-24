package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingRunnable implements Runnable{
    private static ExecutorService executor;
    public void printText() {
        for(int i = 0; i < 10; i++) System.out.println(i+". Printing text");
        executor.shutdown();
    }
    @Override
    public void run() {
        System.out.println("Inside run method");
        printText();
    }

    public static void main(String[] args) {
        UsingRunnable a = new UsingRunnable();
        executor = Executors.newFixedThreadPool(4);
        executor.execute(a);
        System.out.println("Hii ====>");
    }
}
