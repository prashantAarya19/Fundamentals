package recursion.practice;

import java.util.ArrayList;
import java.util.List;

public class KSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int k = 3;
//        solve(arr, 0, 0, k, new ArrayList<>());
        solve2(arr, 0, 0, k, new ArrayList<>());
    }

    private static void solve(int[] arr, int i, int sum, int k, List<Integer> list) {
        if(i == arr.length) {
            if(sum == k)
                System.out.println(list);
            return;
        }

//        if(sum > k)
//            return;

        list.add(arr[i]);
        solve(arr, i + 1, sum + arr[i], k, list);
        list.remove(list.size() - 1);
        solve(arr, i + 1, sum, k, list);

    }

    private static boolean solve2(int[] arr, int i, int sum, int k, List<Integer> list) {
        if(i == arr.length) {
            if(sum == k) {
                System.out.println(list);
                return true;
            }
            return false;
        }
        list.add(arr[i]);
        sum += arr[i];
        if(solve2(arr, i + 1, sum, k, list))
            return true;
        list.remove(list.size() - 1);
        sum -= arr[i];
        if(solve2(arr, i + 1, sum, k, list))
            return true;

        return false;
    }

}
