package recursion;

public class PivotInArray {
    public static void main(String[] args) {
        int[] arr = {6, 7, 9, 1, 2, 3}; // 3
       // int[] arr = {8, 9, 10, 11, 2, 3, 5, 6}; // 4
        System.out.println(findPivot(arr, 0 , arr.length - 1));
    }

    private static int findPivot(int[] arr, int s, int e) {
        if(s == e) {
            return s;
        }

        int mid = s + (e - s)/2;

        if(arr[mid] > arr[0])
            return findPivot(arr, mid + 1, e);
        else
            return findPivot(arr, s, mid);
    }
}
