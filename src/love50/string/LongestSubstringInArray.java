package love50.string;

import java.util.*;

public class LongestSubstringInArray {
    public static void main(String[] args) {
//        String[] arr = {"abc", "aba", "za"};
//        Arrays.sort(arr);
//        Arrays.stream(arr).forEach(e -> System.out.print(e+" "));
    }

    private String solve(String[] strs, int ind, String s) {
        if(ind == strs[0].length())
            return s;
        boolean isPresent = true;
        char currentChar = strs[0].charAt(ind);
        for(int i = 1; i < strs.length; i++) {
            if(ind == strs[i].length() || strs[i].charAt(ind) != currentChar) {
                isPresent = false;
                break;
            }
        }
        if(isPresent) {
            return solve(strs, ind + 1, s+currentChar);
        } else {
            return s;
        }
    }

    private String solve2(String[] strs) {
        Arrays.sort(strs);

        String s1 = strs[0];
        String s2 = strs[strs.length - 1];

        int i1 = 0;
        int i2 = 0;
        int matchCount = 0;
        while(i1 < s1.length() && i2 < s2.length()) {
            if(s1.charAt(i1) == s2.charAt(i2)) {
                i1++;
                i2++;
                matchCount++;
            } else {
                break;
            }
        }

        return s1.substring(0, matchCount);
    }
}
