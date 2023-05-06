package recursion.practice;

import java.util.ArrayList;

public class SubSetSum {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> result = new ArrayList<>();
        solve(arr, N, 0, result, 0);
        return result;
    }

    private void solve(ArrayList<Integer> arr, int n, int sum, ArrayList<Integer> result, int ind) {
        if(ind == n) {
            result.add(sum);
            return;
        }

        solve(arr, n, sum + arr.get(ind), result, ind + 1);
        solve(arr, n, sum, result, ind + 1);
    }
}
