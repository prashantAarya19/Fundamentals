package arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Sort012 {
    public static void main(String[] args) {
        //int[] arr = {1,1,2,0,0,2,1,1};
        int[] arr = {0, 2, 2, 1, 0, 1, 2};
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(1);
//        list.add(2);
//        list.add(0);
//        list.add(0);
//        list.add(2);
//        list.add(1);
//        list.add(1);
        sort(arr);
        System.out.println(Arrays.toString(arr));
       // sortInLinkedList(list);
       // System.out.println("Size:::"+list.size() +"\n"+list);
    }
    public static void sort(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        int mid = 0;

        while(mid <= e) {
            if(arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[s];
                arr[s] = temp;
                mid++;
                s++;
            }
            if(arr[mid] == 2) {
                int temp = arr[mid];
                arr[mid] = arr[e];
                arr[e] = temp;
                e--;
            }
            if(arr[mid] == 1) {
                mid++;
            }
        }
    }

    public static void sortInLinkedList(LinkedList<Integer> list) {
        int s = 0;
        int mid = 0;
        int e = list.size()-1;

        while(mid <= e) {
            if(list.get(mid) == 0) {
                int temp = list.get(mid);
                int tempMid = mid + 1;
                int tempStart = s+1;
                list.add(mid, list.get(s));
                list.remove(tempMid);
                list.add(s, temp);
                list.remove(tempStart);
                mid++;
                s++;
            }

            if(list.get(mid) == 2) {
                int temp = list.get(mid);
                int tempMid = mid+1;
                int tempEnd = e+1;
                list.add(mid, list.get(e));
                list.remove(tempMid);
                list.add(e, temp);
                list.remove(tempEnd);
                e--;
            }

            if(list.get(mid) == 1) {
                mid++;
            }
        }
    }
}
