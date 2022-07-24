import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

public class Test{
    String val = "Straw";

    public void m(String val) {
        this.val = "blue";
        System.out.println(val + "bery");
    }



    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);

        Collections.fill(list, 2);
        System.out.println(list.size());
    }

}
