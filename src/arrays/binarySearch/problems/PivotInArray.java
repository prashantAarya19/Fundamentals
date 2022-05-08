package arrays.binarySearch.problems;

public class PivotInArray {

    public static int pivotInArray(int[] arr, int length) {
        int start = 0;
        int end = length - 1;
        int mid = start + (end - start)/2;
        if(arr[start] < arr[end]) {
            return start;
        }
        while(start < end) {
            if(arr[mid] >= arr[0]) {
                start = mid + 1;
            } else {
                end = mid;
            }
            mid = start + (end - start)/2;
        }
        return start;
    }

    public static void main(String[] args) {
       // int[] arr = {4, 6, 8, 9, 2};
       // int[] arr = {8, 9, 10, 11, 2, 3, 5, 6};
        //int[] arr = {6, 7, 9, 1, 2, 3};
        int[] arr = {2, 3, 5, 8};
        System.out.println(pivotInArray(arr, 4));
    }
}
