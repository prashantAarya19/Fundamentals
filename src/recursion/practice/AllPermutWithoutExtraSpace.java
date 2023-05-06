package recursion.practice;

import java.util.ArrayList;
import java.util.List;

public class AllPermutWithoutExtraSpace {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(nums, result, 0);
        return result;
    }

    private static void solve(int[] nums, List<List<Integer>> result, int ind) {
        if(ind == nums.length) {
            result.add(copyArrayToList(nums));
            return;
        }

        for(int i = ind; i < nums.length; i++) {
            swap(nums, ind, i);
            solve(nums, result, ind + 1);
            swap(nums, ind, i);
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
    private static List<Integer> copyArrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i : arr) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3};
//        List<List<Integer>> permute = permute(arr);
//        System.out.println(permute);
        char[] c = {'a', 'b', 'c'};
        String s = new String(c);
        System.out.println(s);

    }
}
