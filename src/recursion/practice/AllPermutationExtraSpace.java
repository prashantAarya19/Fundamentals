package recursion.practice;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationExtraSpace {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(nums, result, new ArrayList<>(), new int[nums.length]);
        return result;
    }

    private static void solve(int[] nums, List<List<Integer>> result, List<Integer> permut, int[] visited) {
        if(permut.size() == nums.length) {
            result.add(new ArrayList<>(permut));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(visited[i] != 0)
                continue;
            visited[i] = 1;
            permut.add(nums[i]);
            solve(nums, result, permut, visited);
            visited[i] = 0;
            permut.remove(permut.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> permute = permute(arr);
        System.out.println(permute);
    }
}
