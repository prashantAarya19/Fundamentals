package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationString {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        findPermutations(nums, result, permutation);
        return result;
    }

    private static void findPermutations(int[] nums, List<List<Integer>> result, List<Integer> permutation) {
        if (permutation.size()  >= nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i])) continue;
            permutation.add(nums[i]);
            findPermutations(nums, result, permutation);
            permutation.remove(permutation.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);

    }
}
