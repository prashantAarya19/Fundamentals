package recursion;

public class MultiplyArray {
    public static void main(String[] args) {
        int[] arr = {4};

        System.out.println(multiply(arr, arr.length));
    }

    private static int multiply(int[] arr, int length) {
        if(length <= 0)
            return 1;

        return multiply(arr, length - 1) * arr[length - 1];

    }
}
