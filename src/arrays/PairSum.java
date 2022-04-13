package arrays;

public class PairSum {

    public static int[][] pairSum(int[] arr, int s) {
        int[][] result = new int[arr.length][2];

        for(int i = 0; i < arr.length; i++) {
            int input = arr[i];
            for(int j = i+1; j < arr.length; j++) {
                if(input + arr[j] == s) {
                    int min = Integer.min(input, arr[j]);
                    int max = Integer.max(input, arr[j]);
                    result[i][0] = min;
                    result[i][1] = max;
                }
            }
        }
       // Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {2, -3, 3, 3, -2};
        int[][] ints = pairSum(arr, 0);

        printArray(ints);
    }

    public static void printArray(int[][] arr) {
        for (int[] anInt : arr) {
            for (int col = 0; col < 2; col++) {
                System.out.print(anInt[col] + " ");
            }
            System.out.println();
        }
    }
}
