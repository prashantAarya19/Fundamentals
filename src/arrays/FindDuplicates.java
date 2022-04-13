package arrays;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> occurrenceCount = new HashMap<>();
        for(int i : nums) {
            occurrenceCount.put(i, occurrenceCount.getOrDefault(i, 0)+1);
        }
        return occurrenceCount
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Integer> findDuplicates2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int row = 0;
        if(nums.length == 1) {
            return Collections.emptyList();
        }
        while(row < nums.length) {
            int col = row + 1;
            int a = nums[row];
            while(col < nums.length) {
                if(nums[col] == -1) {
                    ++row;
                    break;
                }
                if(nums[col] == a) {
                    result.add(a);
                    nums[col] = -1;
                    break;
                }
                ++col;
            }
            ++row;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] arr = {4,3,2,7,8,2,3,1};
       // int[] arr = {1,1,2};
       // int[] arr = {5,4,6,7,9,3,10,9,5,6};

        int[] arr = {1};
       // List<Integer> duplicates = findDuplicates(arr);
        List<Integer> duplicates = findDuplicates2(arr);
        duplicates.forEach(e -> System.out.print(" "+e));
    }
}
