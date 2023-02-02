package love50.arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.get(0)[1] = 4;
        System.out.print(list.get(0)[0] +" "+ list.get(0)[1]);
    }
}
