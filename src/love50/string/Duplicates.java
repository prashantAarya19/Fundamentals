package love50.string;

import java.util.HashMap;
import java.util.Map;

public class Duplicates {
    public static void main(String[] args) {
        String str = "ababcdd";
        System.out.println(str.indexOf("pqr"));
        System.out.println(findDuplicates(str));
    }

    private static String findDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        for(Character c : map.keySet()) {
            if(map.get(c) > 1)
                result .append(c);
        }
        return result.toString();
    }


}
