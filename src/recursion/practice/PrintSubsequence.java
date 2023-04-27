package recursion.practice;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        solve(arr, 0, new ArrayList<>());
    }

    private static void solve(int[] arr, int i, List<Integer> list) {
        if(i == arr.length) {
            System.out.println(list);
            System.out.println();
            return;
        }

        list.add(arr[i]);
        solve(arr, i + 1, list);
        list.remove(list.size() - 1);
        solve(arr, i + 1, list);
    }
}
