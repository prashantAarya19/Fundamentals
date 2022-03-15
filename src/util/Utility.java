package util;

import java.util.Arrays;

public class Utility {
    public static void printArray(int[] arr) {
        Arrays.stream(arr)
                .forEach(elm -> System.out.print(elm +" "));

        System.out.println();
    }

}
