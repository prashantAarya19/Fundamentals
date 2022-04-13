package arrays;

public class FindDuplicateElement {

    public static int findDuplicateElement(int[] arr) {
        int result = 0;
        for(int e : arr) {
            result = result ^ e;
        }
        for(int i = 1; i < arr.length; i++) {
            result = result ^ i;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 4, 3, 6};

        System.out.println(findDuplicateElement(arr));
    }

}
