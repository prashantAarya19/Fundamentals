package love50.arrays;

import java.util.HashSet;
import java.util.Set;

import static util.Utility.printArray;

public class MoveAllTheNegativeNumber {

    public static void moveAllTheNegativeNumbers(int[] arr) {
        int s = 0;
        int e = arr.length - 1;

        while(s <= e) {
            if(arr[s] > 0) {
                swap(s, e, arr);
                e--;
            } else {
                s++;
            }
        }
    }

    public static void swap(int i1, int i2, int[] arr) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        moveAllTheNegativeNumbers(arr);
        printArray(arr);
    }
}
