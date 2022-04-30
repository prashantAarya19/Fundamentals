package arrays;

import java.util.*;

public class MajorityElement {

    // Using HashMap TC: O(N) SC: O(N)
    public static int majorityCount(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        Set<Integer> set =  map.keySet();

        int number = -1;
        int occurrenceCount = -1;

        for(int i : set) {
            if(map.get(i) > occurrenceCount) {
                number = i;
                occurrenceCount = map.get(i);
            }
        }
        return number;
    }

    // Using Moore's algorithm TC: O(N) SC: O(1)
    //*** only applicable when max occurrence is n/2+1
    public static int majorityNumberCount(int[] arr) {
        int count = 0;
        int maxOccurredNumber = -1;

        for(int i : arr) {
            if(count == 0) {
                maxOccurredNumber = i;
            }

            count +=(maxOccurredNumber == i)? 1 : -1;
        }
        return maxOccurredNumber;
    }
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,1,2,3};
        System.out.println("using HashMap "+ majorityCount(arr)); // ans: 2
        System.out.println("using Moore's algo "+ majorityNumberCount(arr)); // ans: 2
    }
}
