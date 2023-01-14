package dp;

import java.util.Arrays;
import java.util.List;

public class RussianDoll {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {5, 4}, {6, 4}, {6, 7}, {2, 3}
        };

        List<int[]> ints = Arrays.stream(arr).sorted((e1, e2) -> {
            if (e1[0] != e2[0])
                return Integer.compare(e1[0], e2[0]);
            else
                return Integer.compare(e2[1], e1[1]);
        }).toList();
        ints.forEach(e -> System.out.print(e[1]+" "));

    }
}
