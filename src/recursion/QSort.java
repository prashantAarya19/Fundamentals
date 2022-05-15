package recursion;

import java.util.Arrays;

public class QSort {
    public static void main(String[] args) {
//        int[] arr = {9, 4, 11, 3, 6, 45, 6, 6, 84, 33};
//        int[] arr = {9, 4, 11, 3, 6, 45, 84, 33, 33, 33, 10};
       // int[] arr = {6, 6, 8, 5, 8};
        int[] arr = {-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
//        int[] arr = {-74,48,-20,2,10,-84,-5,-9,11,-24,-91};
//        int[] arr = {5,1,1,2,0,0};
        quickSort(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(e -> System.out.print(e +" "));
    }

    private static void quickSort(int[] arr, int s, int e) {
        if(s > e)
            return;

        int pivotIndex = partition(arr, s, e);

        // Sort left part
        quickSort(arr, s, pivotIndex - 1);
        // Sort right part
        quickSort(arr, pivotIndex + 1, e);
    }

    private static int partition(int[] arr, int s, int e) {
       int pivotElm = arr[s];
       int count = 0;
       for(int i = s + 1; i <= e; i++) {
           if(arr[i] <= pivotElm)
               ++count;
       }
       int pivIndex = s + count;
       swap(arr, s, pivIndex);
       int i = s;
       int j = e;
       while(i < pivIndex && j > pivIndex) {
           while(arr[i] <= arr[pivIndex])
               ++i;

           while(arr[j] > arr[pivIndex])
               --j;

           if(i < pivIndex && j > pivIndex)
               swap(arr, i++, j--);
       }
       return pivIndex;
    }

    private static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}
