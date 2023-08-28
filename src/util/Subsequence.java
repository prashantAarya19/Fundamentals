package util;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        List<List<Integer>> result = new ArrayList<>();
        solve(arr, 0, result, new ArrayList<>());
        System.out.println(result);
    }

    private static void solve(int[] arr, int i, List<List<Integer>> result, ArrayList<Integer> sequence) {
        if(i == arr.length) {
            if(!sequence.isEmpty())
                result.add(new ArrayList<>(sequence));
            return;
        }

        sequence.add(arr[i]);
        solve(arr, i + 1, result, sequence);
        sequence.remove(sequence.size() - 1);
        solve(arr, i + 1, result, sequence);
    }
}
