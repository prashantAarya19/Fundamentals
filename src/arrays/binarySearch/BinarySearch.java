package arrays.binarySearch;

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
        return -1;
    }

    private int bs(int[] arr, int target, int s, int e) {
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2};
//        int[] arr = {2, 4, 6, 8, 25, 27, 28};
        System.out.println(binarySearch(arr, 3, 0));
    }
}
