package recursion;

import java.util.ArrayList;
import java.util.List;

public class PhoneKeypadProblem {
    public static void main(String[] args) {
        String digits = "23";
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mnop", "qrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        String combination = "";
        findCombination(digits, 0, result, combination, mapping);
       // result.forEach(e -> System.out.print(e +" "));
        System.out.println(result);
    }

    private static void findCombination(String digits, int i, List<String> result, String combination, String[] mapping) {
        if(i >= digits.length()) {
            result.add(combination);
            return;
        }

        int p = digits.charAt(i) - '0';
        String val = mapping[p];
        for(int j = 0; j < val.length(); j++) {
            combination += val.charAt(j);
            findCombination(digits, i+1, result, combination, mapping);
            combination = combination.substring(0, combination.length() - 1);
        }
    }
}
