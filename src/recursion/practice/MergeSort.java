package recursion.practice;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {3, 4, 2, 54, 23, 1, 99, 22};
        int[] arr = {4, 1, 3, 9, 7};
        Arrays.stream(arr).forEach(e -> System.out.print(e +" "));
        System.out.println();
        solve(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(e -> System.out.print(e +" "));
    }

    private static void solve(int[] arr, int start, int end) {
//        if(end - start == 1)
//            return;
        if(end == start)
            return;

        int mid = start + (end - start) / 2;

        solve(arr, start, mid);
        solve(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] result = new int[end - start + 1];

        int s1 = start;
        int s2 = mid + 1;
        int counter = 0;
        while(s1 <= mid && s2 <= end) {
            if(arr[s1] < arr[s2])
                result[counter++] = arr[s1++];
            else
                result[counter++] = arr[s2++];
        }

        while(s1 <= mid)
            result[counter++] = arr[s1++];

        while(s2 <= end)
            result[counter++] = arr[s2++];

        System.arraycopy(result, 0, arr, start, result.length);
    }
}
