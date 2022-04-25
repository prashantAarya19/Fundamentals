package arrays;

import java.util.Arrays;

public class MoveZeroes {

    public static void move(int[] arr) {
        int s = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                int temp = arr[s];
                arr[s] = arr[i];
                arr[i] = temp;
                ++s;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        move(arr);
        Arrays.stream(arr).forEach(e -> System.out.print(e+" "));
    }
}
