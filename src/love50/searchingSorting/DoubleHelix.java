package love50.searchingSorting;

public class DoubleHelix {
    public static void main(String[] args) {
//        int[] arr1 = {3, 5, 7, 9, 20, 25, 30, 40, 55, 56, 57, 60, 62};
//        int[] arr2 = {1, 4, 7, 11, 14, 25, 44, 47, 55, 57, 100};
        int[] arr1 = {-5, 100, 1000, 1005};
        int[] arr2 = {-12, 1000, 1001};

        System.out.println(maxSum(arr1, arr2));
    }

    private static int maxSum(int[] arr1, int[] arr2) {
        int i1 = 0;
        int n1 = arr1.length;
        int i2 = 0;
        int n2 = arr2.length;

        int sum1 = 0;
        int sum2 = 0;

        while(i1 < n1 && i2 < n2) {
            sum1 += arr1[i1];
            sum2 += arr2[i2];
            if(arr1[i1] == arr2[i2]) {
                int max = Math.max(sum1, sum2);
                sum1 = sum2 = max;
            }
            i1++;
            i2++;
        }

        while(i1 < n1)
            sum1 += arr1[i1++];

        while (i2 < n2)
            sum2 += arr2[i2++];
        return Math.max(sum1, sum2);
    }
}
