package recursion.practice;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    private void solve(int[] arr, int target, int index, List<List<Integer>> result, List<Integer> combinations) {
        if(index == arr.length) {
            if(target == 0) {
                result.add(new ArrayList<>(combinations));
            }
            return;
        }

        if(arr[index] <= target) {
            combinations.add(arr[index]);
            solve(arr, target - arr[index], index, result, combinations);
            combinations.remove(combinations.size() - 1);
        }

        solve(arr, target, index + 1, result, combinations);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        solve(candidates, target, 0, result, new ArrayList<>());
        return result;
    }
}
