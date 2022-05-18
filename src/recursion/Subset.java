package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = subsets(arr);
        System.out.println(result);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        int s = 0;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> node = new ArrayList<>();
        getSuperSet(nums, s, result, node);
        return result;
    }

    public static void getSuperSet(int[] nums, int s, List<List<Integer>> result, List<Integer> node) {

        if(s > nums.length - 1) {
            result.add(new ArrayList<>(node));
            return;
        }

        // exclude
        getSuperSet(nums, s + 1, result, node);
        // include
        node.add(nums[s]);
        getSuperSet(nums, s + 1, result, node);
        node.remove(node.size()-1);
    }
}
