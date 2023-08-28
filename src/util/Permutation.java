package util;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        solve(arr, new int[arr.length], result, new ArrayList<>());
        System.out.println(result);
    }

    private static void solve(int[] arr, int[] visited, List<List<Integer>> result, ArrayList<Integer> permut) {
        if(permut.size() == arr.length) {
            result.add(new ArrayList<>(permut));
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == 0) {
                permut.add(arr[i]);
                visited[i] = 1;
                solve(arr, visited, result, permut);
                visited[i] = 0;
                permut.remove(permut.size() - 1);
            }
        }
    }
}
