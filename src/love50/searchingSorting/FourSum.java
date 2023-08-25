package love50.searchingSorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FourSum {

    public static void main(String[] args) {
        int key = 3;
        int[] arr = {0, 0, 2, 1, 1};
        System.out.println(fourSum(arr, key));
    }
    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int elm : arr) {
            map.put(elm, map.getOrDefault(elm, 0) + 1);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        return result;
    }
}
