package recursion;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2};

        System.out.println("Is value present : "+ isPresent(arr, arr.length - 1, 2));
    }

    private static boolean isPresent(int[] arr, int length, int k) {
        if(length <= 0 && arr[length] != k) {
            return false;
        }

        if(arr[length] == k) {
            return true;
        }
        return isPresent(arr, length - 1, k);
    }
}
