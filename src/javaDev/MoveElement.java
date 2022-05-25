package javaDev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MoveElement {

    public static void main(String[] args) {
        int[] arr = {0, 2, 2, 1, 0, 1, 2};
//        moveElement(arr);
//        Arrays.stream(arr).forEach(e -> System.out.print(e +" "));
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        System.out.println(l);
        l.set(0, 3);
        System.out.println(l);
    }

    private static void moveElement(int[] arr) {
        int s = 0;
        int mid = 0;
        int e = arr.length - 1;

        while(mid <= e) {
            if(arr[mid] == 0) {
                swap(arr, mid, s);
                ++mid;
                ++s;
            }

            if(arr[mid] == 2) {
                swap(arr, mid, e);
                --e;
            }

            if(arr[mid] == 1) {
                ++mid;
            }
        }
    }

    private static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}
