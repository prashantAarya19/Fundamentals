package love50.arrays;

import java.util.Arrays;

import static util.Utility.printArray;

public class CountInversion {
    public static void main(String[] args) {
        long[] arr = {1, 2, 4};
        long[] a = Arrays.copyOfRange(arr, 0, 1);
        printArray(a);
    }
}
