package love50.string;

import java.util.ArrayList;
import java.util.List;

public class RecursivelyPrintSentence {
    public static void main(String[] args) {
        String[][] arr = {{"you", "we"},
                          {"have", "are"},
                          {"sleep", "eat", "drink"}};

//        List<List<String>> result = new ArrayList<>();
//        solve(arr, 0, result, new ArrayList<>());
//        for(List<String> list : result) {
//            for(String s : list)
//                System.out.print(s + " ");
//            System.out.println();
//        }
        solve2(arr, 0, new ArrayList<>());
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer reduce = list.stream().reduce(1, (result, e) -> result * e);
        System.out.println(reduce);
    }

    private static void solve(String[][] arr, int row, List<List<String>> result, List<String> list) {
        if(row == arr.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int col = 0; col < arr[row].length; col++) {
            list.add(arr[row][col]);
            solve(arr, row + 1, result, list);
            list.remove(list.size() - 1);
        }
    }

    private static void solve2(String[][] arr, int row, List<String> list) {
        if(row == arr.length) {
            return;
        }

        for(int col = 0; col < arr[row].length; col++) {
            list.add(arr[row][col]);
            solve2(arr, row + 1, list);
            if(list.size() == arr.length)
                printList(list);
            list.remove(list.size() - 1);
        }
    }

    private static void printList(List<String> list) {
        for(String s : list)
            System.out.print(s+" ");
        System.out.println();
    }
}
