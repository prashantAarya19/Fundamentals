package love50.arrays;

public class RotateArray {
    //using juggling algorithm
    static void rotateArr(int arr[], int d, int n)
    {
        d = d % n;
        int gcd = getGCD(d, n);
        int j = 0;
        int k = 0;

        for(int i = 0; i < gcd; i++) {
            j = i;
            int temp = arr[j];

            while(true) {
                k = j + d;

                if(k >= n) {
                    k = k - n;
                }

                if(k == i) {
                    break;
                }

                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }

    }

    private static int getGCD(int d, int n) {
        if(n == 0)
            return d;

        return getGCD(n, d % n);
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    }
}
