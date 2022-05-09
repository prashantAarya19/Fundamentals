package recursion;

import java.util.Arrays;

public class MinMagneticForce {

    public static int findMinMagneticForce(int[] arr, int m, int s, int e, int maxDist) {
        if(s == e) {
            return maxDist;
        }

        int mid = s + (e - s)/2;

        if(isValidPosition(arr, m, mid, arr[0], 1, 0)) {
            return findMinMagneticForce(arr, m, mid+1, e, mid);
        } else {
            return findMinMagneticForce(arr, m, s, mid - 1, mid);
        }
    }

    private static boolean isValidPosition(int[] arr, int m, int mid, int s, int ballCount, int i) {
        if(ballCount == m)
            return true;

        if(i == arr.length) {
            return false;
        }

        if(arr[i] - s >= mid) {
           return isValidPosition(arr, m, mid, arr[i], ++ballCount, ++i);
        } else {
            return isValidPosition(arr, m, mid, s, ballCount, ++i);
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,7}; // 6
        int[] arr = {5,4,3,2,1,1000000000}; //999999
        Arrays.sort(arr);
        System.out.println(findMinMagneticForce(arr, 2, 0, arr[arr.length-1], -1));
    }
}
