package love50.string;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowInString {
    public static void main(String[] args) {
        String str = "timetopractice";
        String pat = "toc";

//        System.out.println(smallestWindow(str, pat));
        System.out.println(solve2(str, pat));
    }
    public static String smallestWindow(String s, String p)
    {
        // naive approach
        /**
         * 1. find in the largest window
         * 2. reduce the window from start and check the pattern
         * 3. reduce the window from end and check the pattern
         **/

        return solve(s, p, "-1");
    }

    private static boolean isPresent(String s, String p) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = p.toCharArray();

        for(int i = 0;  i < arr1.length; i++) {
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }


    private static String solve(String s, String p, String result) {
        if(s.length() < p.length())
            return "";

        if(isPresent(s, p)) {
            String s1 = solve(s.substring(1, s.length()), p, s);
            String s2 = solve(s.substring(0, s.length() - 1), p, s);

            if(s1.length() < s2.length())
                return s1;
            else
                return s2;
        }

        return s;
    }

    private static String solve2(String text, String pattern) {
        Map<Character, Integer> patMap = new HashMap<>();

        for(char c : pattern.toCharArray())
            patMap.put(c, patMap.getOrDefault(c, 0) + 1);


        Map<Character, Integer> textMap = new HashMap<>();
        int mc = pattern.length();
        int cmc = 0;

        int start = 0;
        int counter = 0;

        String result = "-1";

        while(true) {
            boolean acquireFlag = false;
            boolean releaseFlag = false;
            // acquire
            while(counter < text.length() && cmc < mc) {
                char key = text.charAt(counter++);
                textMap.put(key, textMap.getOrDefault(key, 0) + 1);
                if(patMap.getOrDefault(key, 0) >= textMap.get(key)) {
                    cmc++;
                }
                acquireFlag = true;
            }

            // release
            while(start < counter && cmc == mc) {
                String possibleSubstring = text.substring(start, counter);
                if(result.equals("-1") || result.length() > possibleSubstring.length())
                    result = possibleSubstring;

                char key = text.charAt(start++);
                if(textMap.get(key) == 1) {
                    textMap.remove(key);
                } else {
                    textMap.put(key, textMap.get(key) - 1);
                }

                if(patMap.getOrDefault(key, 0) > textMap.getOrDefault(key, 0))
                    mc--;
                releaseFlag = true;
            }

            if(!acquireFlag && !releaseFlag)
                break;
        }
        return result;
    }
}
