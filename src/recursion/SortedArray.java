package recursion;

public class SortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        System.out.println(isSorted(arr, 1, arr.length - 1));
    }

    private static boolean isSorted(int[] arr, int start, int n) {

        if(arr.length-1 == 0)
            return true;

        if(start == n && arr[start] > arr[start-1])
            return true;

        if(arr[start] < arr[start-1])
            return false;


        return isSorted(arr, start+1, n);
    }
}
