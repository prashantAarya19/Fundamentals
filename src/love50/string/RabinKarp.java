package love50.string;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp {
    private static final int totalChar = 256;
    public static void main(String[] args) {
        String text = "THIS TEXT A TEST TEXT", pattern = "TEXT";
        System.out.println(findPattern(text, pattern));
        System.out.println(findPatternUsingHashing(text, pattern));

    }

    private static String findPattern(String text, String pattern) {
        int s = 0, e = pattern.length() - 1;
        String result = "";
        while(e < text.length()) {
            if(text.substring(s, e + 1).equals(pattern))
                result += " "+s;
            s++;
            e++;
        }
        return result;
    }

    private static List<Integer> findPatternUsingHashing(String text, String pattern) {
        List<Integer> list = new ArrayList<>();
        int windowLength = pattern.length();
        int currentWindowHash = 0;
        int patternHash = 0;

        // find current window and pattern hash
        for(int i = 0; i < pattern.length(); i++) {
            patternHash += pattern.charAt(i) * findPower(windowLength);
            currentWindowHash += text.charAt(i) * findPower(windowLength);
            windowLength--;
        }
        windowLength = pattern.length();
        if(currentWindowHash == patternHash)
            list.add(0);
        int s = 0;
        for(int i = pattern.length(); i < text.length(); i++) {
            currentWindowHash = ( (currentWindowHash - (text.charAt(s) * findPower(windowLength))) * 10 ) + text.charAt(i);
            if(currentWindowHash == patternHash && text.substring(s + 1, i+1).equals(pattern)) {
                list.add(s + 1);
            }
            s++;
        }
        return list;
    }

    private static int findPower(int n) {
        int pow = 1;
        for(int i = 1; i < n; i++) {
           pow *= 10;
        }
        return pow;
    }
}
