package love50.arrays;

import static util.Utility.printArray;

public class RearrangePositiveNegative {
    public static void main(String[] args) {
        int[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};

        int s = 0, c = 0;
        int n = arr.length;

        while(s < n && c < n) {
            if(c % 2 == 0 && arr[c] > 0 && arr[s] < 0)
                swap(s++, c, arr);
            else if(c % 2 != 0 && arr[c] < 0 && arr[s] >= 0)
                swap(s++, c, arr);
            else if(c % 2 == 0 && arr[s] < 0)
                s++;
            else if(c % 2 != 0 && arr[s] >= 0)
                s++;
            c++;
        }
        printArray(arr);

    }

    private static void swap(int i1, int i2, int[] arr) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
