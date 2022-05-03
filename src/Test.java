import java.util.*;
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
        String s = new String("abc");
        String b = new String("a");
        System.out.println(s.matches("^a"));
        System.out.println(s.intern() == b.intern());

    }

}
