package love50.arrays;

import static util.Utility.printArray;

public class RearrangeArray {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, -4, -1, 4};
        int[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        solve(arr, arr.length);
        printArray(arr);
    }

    private static void solve(int[] arr, int n) {
        int outPlace = -1;

        for(int i = 0; i < n; i++) {
            if(outPlace != -1) {
                if((arr[outPlace] < 0 && arr[i] >= 0)
                    || (arr[outPlace] >= 0 && arr[i] < 0)) {
                    rearrange(arr, outPlace, i);
                    if(i - outPlace >= 2)
                        outPlace += 2;
                    else
                        outPlace = -1;
                }
            } else {
                if(((i & 1) == 0 && arr[i] >= 0)
                    || ((i & 1) == 1 && arr[i] < 0)) {
                    outPlace = i;

                }
            }
        }
    }

    private static  void rearrange(int[] arr, int outPlace, int current) {
        int temp = arr[current];
        for(int i = current; i > outPlace; i--) {
            arr[i] = arr[i - 1];
        }
        arr[outPlace] = temp;
    }
}
