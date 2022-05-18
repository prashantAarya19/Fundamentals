package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetString {
    public static void main(String[] args) {
        String str = "ABC";
        List<List<String>> result = new ArrayList<>();
        List<String> node = new ArrayList<>();
        findSubset(str, 0, result, node);
        result.forEach(e -> System.out.print(e + " "));
    }

    private static void findSubset(String str, int i, List<List<String>> result, List<String> node) {
        if (i >= str.length()) {
            if(node.size() != 0) {
                result.add(new ArrayList<>(node));
            }
            return;
        }

        // exclude
        findSubset(str, i + 1, result, node);
        String temp = String.valueOf(str.charAt(i));
        node.add(temp);
        findSubset(str, i + 1, result, node);
        node.remove(node.size() - 1);
    }
}
