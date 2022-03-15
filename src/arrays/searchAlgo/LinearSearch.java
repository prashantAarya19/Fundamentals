package arrays.searchAlgo;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {4, 10, 1, 3, 5};
        System.out.println(search(arr, 22));
    }

    public static boolean search(int[] arr, int key) {
        int i = 0;

        while (i < arr.length) {
            if(arr[i] == key) {
                return true;
            }
            ++i;
        }
        return false;
    }
}
