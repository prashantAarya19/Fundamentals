package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class FindDuplicateElement {

    public static int findDuplicateElement(int[] arr) {
        int result = 0;
        for(int e : arr) {
            result = result ^ e;
        }
        for(int i = 1; i < arr.length; i++) {
            result = result ^ i;
        }
        return result;
    }

    // Floyd's Tortoise and Hare
    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int findDuplicatesUsingFloydAlgo(int[] arr) {

        // [3,1,3,4,2]

        // creating entry point.
        int tortoise = arr[0];
        int hare = arr[0];

        do{
            tortoise = arr[tortoise];
            hare = arr[arr[hare]];
        } while(tortoise != hare);

        // entry point for tortoise
        tortoise = arr[0];
        while(hare != tortoise) {
            tortoise = arr[tortoise];
            hare = arr[hare];
        }
        return hare;
    }

    // Using hashing
    public static int findDuplicates(int[] arr) {
        int[] hashArray = new int[arr.length];

        for (int j : arr) {
            if (hashArray[j] == 1) return j;
            hashArray[j] = 1;
        }
        return -1;
    }

    public static int[] findAllDuplicates(int[] arr) {
        String result = "";
        int[] hashArray = new int[arr.length];

        for(int i : arr) {
            if(hashArray[i] == 1 && !result.contains(i+""))
                    result = result.concat(arr[i]+"");
            hashArray[i] = 1;
        }
        char[] chars = result.toCharArray();
        int[] resultArray = new int[chars.length];
        for(int i = 0; i < chars.length; i++) {
            resultArray[i] = Integer.parseInt(chars[i]+"");
        }
        return resultArray;
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 1};

        findDuplicatesUsingFloydAlgo(arr);
        Arrays.stream(findAllDuplicates(arr)).forEach(e -> System.out.print(e+" "));
    }

}
