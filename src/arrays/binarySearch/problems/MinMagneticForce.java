package arrays.binarySearch.problems;

import java.util.Arrays;

public class MinMagneticForce {
    public static boolean isValidPosition(int[] position, int m, int mid) {
        int magnetCount = 1;
        int lastPosition = position[0];

        for(int i = 0; i < position.length; i++) {
            if(position[i] - lastPosition >= mid) {
                ++magnetCount;
                if(magnetCount == m) {
                    return true;
                }
                lastPosition = position[i];
            }
        }
        return false;
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int s = 0;
        int e = position[position.length-1];
        int mid = s + (e - s)/2;
        int relativePosition = -1;

        while(s <= e) {
            if(isValidPosition(position, m, mid)) {
                relativePosition = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }

            mid = s + (e - s)/2;
        }
        return relativePosition;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,1000000000};
        System.out.println(maxDistance(arr, 2));
    }
}
