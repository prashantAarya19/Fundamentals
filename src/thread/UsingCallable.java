package thread;

import java.util.concurrent.*;

public class UsingCallable implements Callable<Integer> {
    public int sum() {
        System.out.println("Calculating sum");
        return 4+5;
    }

    @Override
    public Integer call() throws Exception {
        return sum();
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> submit = executor.submit(new UsingCallable());
        System.out.println(submit.get());
        executor.shutdown();
    }
}
