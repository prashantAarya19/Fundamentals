package love50.string;

import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
    }

    private static boolean wordBreak(String str, List<String> list, int index) {
        if(index == str.length())
            return true;

        String temp = "";

        for(int i = index; i <= str.length(); i++) {
            temp += str.charAt(i);
            if(isPresent(list, temp) && wordBreak(str, list, index + 1))
                return true;
        }
        return false;
    }

    private static boolean isPresent(List<String> list, String target) {
        for(String s : list) {
            if(s.equals(target))
                return true;
        }
        return false;
    }
}
