package recursion.practice;

public class InversionCount {
    public static void main(String[] args) {
        long[] arr = {5, 3, 2, 4, 1};
        long N = 5;
        long x = inversionCount(arr, N);
        System.out.println(x);
    }
    static long inversionCount(long arr[], long N)
    {
        return solve(arr, 0, (int)N);
    }

    static long solve(long[] arr, int left, int right) {
        long count = 0;
        if(right - left != 1) { //***
            int mid = left + (right - left) / 2;
            count += solve(arr, left, mid);
            count += solve(arr, mid, right);
            count += mergeAndCount(arr, left, right, mid);
        }

        return count;
    }
    //[2, 3, 4, 5] s = 1 e = 5 m = 2 arr = (e - s) = 4
    //    {5, 3, 2, 4, 1};
    static long mergeAndCount(long[] arr, int left, int right, int mid) {
        long[] temp = new long[right - left];
        int counter = 0;
        int i1 = left;
        int i2 = mid;
        long count = 0;
        while(i1 < mid && i2 < right) {
            if(arr[i1] <= arr[i2])
                temp[counter++] = arr[i1++];
            else {
                temp[counter++] = arr[i2++];
                count += (mid - i1); //****
            }
        }

        while(i1 < mid) {
            temp[counter++] = arr[i1++];
        }

        while(i2 < right) {
            temp[counter++] = arr[i2++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);
        return count;

    }
}
