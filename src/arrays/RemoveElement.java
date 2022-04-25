package arrays;

import java.util.Arrays;
import java.util.List;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int s = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[s] = nums[i];
                ++s;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int[]  ar = {0,1,2,2,3,0,4,2};
        System.out.println("size::"+removeElement(ar, 2));
        List.of(ar)
                .forEach(e -> System.out.print(Arrays.toString(e) +" "));

    }

}
