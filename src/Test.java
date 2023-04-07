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
        Queue<Integer> q = new PriorityQueue<>(5);
        q.add(5);
        q.add(3);
        q.add(1);
        q.add(10);
        q.add(11);

        while(!q.isEmpty())
            System.out.println(q.remove());
    }

}
