package recursion.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        solve(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    private void solve(int[] arr, int target, int ind, List<List<Integer>> result, List<Integer> combi) {

        if(target == 0) {
            result.add(new ArrayList<>(combi));
            return;
        }

        for(int i = ind; i < arr.length; i++) {
            // For not picking the duplicate combination
            if(i > ind && arr[i] == arr[i - 1])
                continue;

            // If element is greater than target no further recursion calls
            if(arr[i] > target)
                break;

            combi.add(arr[i]);
            solve(arr, target - arr[i], i + 1, result, combi);
            combi.remove(combi.size() - 1);
        }
    }
}
