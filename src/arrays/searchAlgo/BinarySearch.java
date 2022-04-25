package arrays.searchAlgo;

public class BinarySearch {

    // Only applicable on monotonic functions
    public static int binarySearch(int[] arr, int size, int key) {
        int start = 0;
        int end = size-1;
        int mid = start + (end-start)/2;

        while(start <= end) {
            if(arr[mid] == key) {
                return mid;
            }

            if(arr[mid] < key) {
                start = mid + 1;
            }

            if(arr[mid] > key) {
                end = mid - 1;
            }

            mid = start + (end-start)/2;
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 25, 27, 28};
        System.out.println(binarySearch(arr, 7, 39));
    }
}
