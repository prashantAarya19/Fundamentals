package arrays;

import java.util.Arrays;

public class Sort0And1 {

    public static void sort0And1(int[] array) {
        int s = 0;
        int e = array.length - 1;

        while(s < e) {
            if(array[s] == 1 && array[e] == 0 ) {
                int temp = array[s];
                array[s++] = array[e];
                array[e--] = temp;
            } else if(array[s] == 0 &&  array[e] == 0) {
                ++s;
            }else {
                --e;
            }

        }
    }

    public static void sortOptimized(int[] arr) {
        int s = 0;
        int e = arr.length - 1;

        while(s < e) {
            if(arr[s] == 0)
                ++s;
            else if(arr[e] == 1)
                --e;
            else {
                int temp = arr[s];
                arr[s++] = arr[e];
                arr[e--] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 0,1, 1};
        sortOptimized(array);
        System.out.println(Arrays.toString(array));
    }
}
