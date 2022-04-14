package arrays.binarySearch;

public class PivotInArray {

    public static int pivotInArray(int[] arr, int length) {
        int start = 0;
        int end = length - 1;
        int mid = start + (end - start)/2;
        while(start < end) {
            if(arr[mid] >= arr[start]) {
                start = mid + 1;
            } else {
                end = mid;
            }
            mid = start + (end - start)/2;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 9, 2};
        System.out.println(pivotInArray(arr, 5));
    }
}
