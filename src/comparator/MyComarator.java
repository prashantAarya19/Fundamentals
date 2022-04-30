package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyComarator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(136);
        list.add(9);
        list.add(3005);

        // sort by greater ending number
        // 9, 136, 3005

        Comparator<Integer> c = (a, b) -> a%10 > b%10 ? -1 : 1;
        list.sort(c);

        System.out.println(list);

    }
}
