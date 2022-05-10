package recursion;

public class FindFirstAndLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 2, 2, 3, 3};

       // System.out.println(findFirstOccurrence(arr, 0, 0, arr.length - 1)); // 1
        System.out.println(findLastOccurrence(arr, 3, 0, arr.length - 1)); // 1
    }

    private static int findFirstOccurrence(int[] arr, int k, int s, int e) {
        if (s > e) {
            return s;
        }
        int mid = s + (e - s) / 2;
        if (arr[mid] == k) {
            return findFirstOccurrence(arr, k, s, mid - 1);
        } else if (arr[mid] < k) {
            return findFirstOccurrence(arr, k, mid + 1, e);
        } else {
            return findFirstOccurrence(arr, k, s, mid - 1);
        }
    }

    private static int findLastOccurrence(int[] arr, int k, int s, int e) {
        if (s > e) {
            return e;
        }

        int mid = s + (e - s) / 2;
        if (arr[mid] == k) {
            return findLastOccurrence(arr, k, mid+1, e);
        } else if (arr[mid] > k) {
            return findLastOccurrence(arr, k, s, mid - 1);
        } else {
            return findLastOccurrence(arr, k, mid + 1, e);
        }
    }


}
