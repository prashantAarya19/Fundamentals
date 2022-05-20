package recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] arr = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};

        List<String> result = new ArrayList<>();
        int[][] track = new int[4][4];
        findPossiblePath(arr, 4, 0, 0, result, track, "");
        System.out.println(result);
    }

    private static void findPossiblePath(int[][] arr, int n, int x, int y, List<String> result, int[][] track, String path) {
        if(arr[0][0] == 0)
            return;

        if(x == n - 1 && y == n - 1) {
            result.add(path);
            return;
        }

        track[x][y] = 1;
        // 4 choices to go L, R, D, U

        // for down
        int newX = x + 1;
        int newY = y;

        if(isPossiblePath(arr, newX, newY, n, track)) {
            path += "D";
            findPossiblePath(arr, n, newX, newY, result, track, path);
            path = path.substring(0, path.length()-1);
        }

        // for up
        newX = x - 1;
       // newY = y;
        if(isPossiblePath(arr, newX, newY, n, track)) {
            path += "U";
            findPossiblePath(arr, n, newX, newY, result, track, path);
            path = path.substring(0, path.length()-1);
        }

        // for right
        newX = x;
        newY = y + 1;
        if(isPossiblePath(arr, newX, newY, n, track)) {
            path += "R";
            findPossiblePath(arr, n, newX, newY, result, track, path);
            path = path.substring(0, path.length()-1);
        }

        // for left
        //newX = x;
        newY = y - 1;
        if(isPossiblePath(arr, newX, newY, n, track)) {
            path += "L";
            findPossiblePath(arr, n, newX, newY, result, track, path);
           // path = path.substring(0, path.length() - 1);
        }
        track[x][y] = 0;
    }

    private static boolean isPossiblePath(int[][] arr, int newX, int newY, int n, int[][] track) {
        return (newX >= 0 && newX < n) &&
                (newY >= 0 && newY < n)
                && track[newX][newY] == 0
                && arr[newX][newY] == 1;
    }
}
