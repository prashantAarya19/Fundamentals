package arrays;

import java.util.Arrays;

/*
* Remove Duplicates from Sorted Array
* */
public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
//        int arr[] = {1, 1, 2, 3, 3, 3, 4};
     //  int[] arr = {0,0,1,1,1,2,2,3,3,4};
       int[] arr = {1,1,1,2};

       /// Arrays.stream(arr).forEach(System.out::println);

        System.out.println(rd.rm(arr));
        Arrays.stream(arr).forEach(e -> System.out.print(e+" "));
    }
    public int rm(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {

            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
