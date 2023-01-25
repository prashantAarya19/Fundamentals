package dp;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        String reverseString = getReverseString(s);
        return solve(s, reverseString);
    }

    private int solve(String s1, String s2) {
        int[] next = new int[s2.length() + 1];
        for(int index1 = s1.length() - 1; index1 >= 0; index1--) {
            int[] current = new int[s2.length() + 1];
            for(int index2 = s2.length() - 1; index2 >= 0; index2--) {
                if(s1.charAt(index1) == s2.charAt(index2)) {
                    current[index2] =  1 + next[index2 + 1];
                } else {
                    current[index2] =  Math.max(next[index2], current[index2 + 1]);
                }
            }
            next = current;
        }

        return next[0];
    }

    private String getReverseString(String s) {
        StringBuilder rev = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            rev.append(s.charAt(i));
        }
        return rev.toString();
    }
}
