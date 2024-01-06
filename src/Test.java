import java.util.Arrays;

public class Test extends RuntimeException {


    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int n = nums.length;
        arrange(nums, n);
        Arrays.stream(nums).forEach(e -> System.out.print(e + " "));
        System.out.println();
        char[] arr1 = giveCharArr("daba");
        char[] arr2 = giveCharArr("adba");
        printArray(arr1);
        printArray(arr2);


    }
    private static void printArray(char[] arr) {
        for(char c : arr) System.out.print(c);
        System.out.println();
    }
    private static char[] giveCharArr(String str) {
        char[] arr = new char[5];
        for(char c: str.toCharArray())
            arr[c - 'a']++;
        return arr;
    }

    private static void arrange(int[] nums, int n) {
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0 || nums[i] >= n) continue;
            int temp = nums[nums[i] - 1]; // 1
            nums[nums[i] - 1] = nums[i]; // -1
            nums[i] = temp;
            //Arrays.stream(nums).forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }
}
