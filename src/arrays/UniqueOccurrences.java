package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        int counter = 0;
        Map<Integer, Integer> elmCount = new HashMap<>();
        while(counter < arr.length) {
            int col = 0;
            elmCount.put(arr[counter], 0);
            while (col < arr.length) {
                if(arr[counter] == arr[col]) {
                    elmCount.put(arr[counter], elmCount.get(arr[counter]) + 1);
                }
                ++col;
            }
            ++counter;
        }

        Set<Integer> s = new HashSet<>(elmCount.values());

        return s.size() == elmCount.size();
    }

    public static boolean uniqueOccurrencesOptimized(int[] arr) {
        Map<Integer, Integer> elmCount = new HashMap<>();
        for(int a : arr) {
            elmCount.put(a, elmCount.getOrDefault(a, 0)+1);
        }

        HashSet<Integer> hs = new HashSet<>(elmCount.values());
        return hs.size()==elmCount.size();
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 3, 3};
        System.out.println(uniqueOccurrencesOptimized(arr));
    }
}
