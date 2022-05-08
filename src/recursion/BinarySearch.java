package recursion;


public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {6, 8};
        System.out.println("Index :: "+ search(arr, 0, arr.length - 1, 8));
    }

    private static int search(int[] arr, int s, int e, int k) {
        if(s > e) {
            return -1;
        }
        int mid = s + (e - s)/2;

        if(arr[mid] == k) {
            return  mid;
        }

        if(arr[mid] > k) {
            return search(arr, s, mid - 1, k);
        } else {
            return search(arr, mid + 1, e, k);
        }
    }
}
