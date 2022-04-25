import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class Test{
    String val = "Straw";

    public void m(String val) {
        this.val = "blue";
        System.out.println(val + "bery");
    }



    public static void main(String[] args) {
        List<Number> l = new ArrayList<>();
        l.add(2);
        l.add(10);
        l.add(4);
        l.add(6);
        l.add(2.2);
        System.out.println(l);


    }

}
