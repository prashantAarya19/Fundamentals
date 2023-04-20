package love50.string;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequence {
    private static void getAllSubsequence(String s, List<String> list, String result) {
        if(s.length() == 0) {
            list.add(result);
            return;
        }

        getAllSubsequence(s.substring(1), list, result + s.charAt(0));

        getAllSubsequence(s.substring(1), list, result);
    }

    public static void main(String[] args) {
        String s = "abc";
        List<String> list = new ArrayList<>();
        getAllSubsequence(s, list, "");
        System.out.println(list);
        System.out.println(s.substring(0, s.length() - 1));
    }
}
