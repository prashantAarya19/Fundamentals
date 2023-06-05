package love50.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static util.Utility.printArray;

public class StringInGrid {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4});

        int[] firstInd = null;
        firstInd = new int[]{1, 2};
        printArray(firstInd);
    }
}
