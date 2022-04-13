package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueElement {


    public static int findUnique(int[] arr) {
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

        Set<Integer> collect = elmCount
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());


        return elmCount
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No unique element found"));

    }

    public static int findUniqueOptimized(int[] arr) {
        int result = 0;
        int i = 0;
        while(i < arr.length) {
            result = result ^ arr[i];
            ++i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 1, 4, 4, 3};

        System.out.println(findUnique(arr));
    }
}
