package love50.arrays;

public class MinOperationToMakePalindrome {
    public static int minOperation(int[] arr, int n) {
        int operations = 0;

        int s = 0;
        int e = n - 1;

        while(s < e) {
            if(arr[s] == arr[e]) {
                s++;
                e--;
            } else if(arr[s] < arr[e]) {
                s++;
                arr[s] += arr[s - 1];
                operations++;
            } else {
                e--;
                arr[e] += arr[e + 1];
                operations++;
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 1};
        System.out.println(minOperation(arr, arr.length));
    }
}
