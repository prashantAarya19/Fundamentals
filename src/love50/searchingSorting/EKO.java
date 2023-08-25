package love50.searchingSorting;

public class EKO {
    public static void main(String[] args) {
//        int[] arr = {20, 15, 10, 17};
        int[] arr = {4, 42, 40, 26, 46};
        int k = 20;
        System.out.println(getMinHeight(arr, k));
    }
    private static int getMinHeight(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = getHigh(arr);

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int acquiredWood = getAcquiredWood(arr, n, mid);

            if(acquiredWood >= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private static int getAcquiredWood(int[] arr, int n, int woodLength) {
        int acquiredWood = 0;
        for(int elm : arr) {
            if(elm > woodLength)
                acquiredWood += elm - woodLength;
        }
        return acquiredWood;
    }

    private static int getHigh(int[] arr) {
        int high = Integer.MIN_VALUE;
        for(int i : arr) high = Math.max(high, i);
        return high;
    }
}
