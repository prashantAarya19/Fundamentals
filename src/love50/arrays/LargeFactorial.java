package love50.arrays;

import java.util.ArrayList;
import java.util.List;

public class LargeFactorial {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.set(0, list.get(0)*3);
        System.out.println(list);
    }
}
