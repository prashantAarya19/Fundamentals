package love50.searchingSorting;

public class RotiParata {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4};
        int[] arr = {1};
//        int k = 10;
        int k = 8;
        System.out.println(getMinTime(arr, k));
    }
    public static int getMinTime(int[] arr, int k) {
        int low = getMaxRank(arr);
        int high = getTotalTimeByMaxRank(low, k);
        int result = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossible(arr, mid, k)) {
                high = mid - 1;
                result = mid;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static boolean isPossible(int[] arr, int mid, int k) {
        int parataCount = 0;
        for(int rank : arr) {
            int currentTime = rank;
            int multiplier = 2;
            while(currentTime <= mid) {
                currentTime += rank * multiplier;
                multiplier++;
                parataCount++;
            }
        }
        return parataCount >= k;
    }

    private static int getTotalTimeByMaxRank(int low, int k) {
        int maxTime = low;
        int multiplier = 2;
        while(k-- > 1) {
            maxTime += (multiplier * low);
            multiplier++;
        }
        return maxTime;
    }

    private static int getMaxRank(int[] arr) {
        int maxRank = Integer.MIN_VALUE;
        for(int rank : arr)
            maxRank = Math.max(rank, maxRank);

        return maxRank;
    }
}
