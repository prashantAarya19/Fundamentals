package dp;

import java.util.HashSet;
import java.util.Set;

public class WildCardMatching {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.charAt(1));
        int a = 3;
        int b = 2;
        System.out.println((a == 1 || b == 1) ? 1 : 0);
    }

    private boolean solve(String s, String p, int index1, int index2) {
        if(index1 < 0 && index2 < 0)
            return true;

        if(index1 >= 0 && index2 < 0)
            return false;

        // **** imp
        if(index1 < 0 && index2 >= 0) {
            for(int i = 0; i <= index2; i++) {
                if(p.charAt(i) != '*')
                    return false;
            }
            return true;
        }


        if(p.charAt(index2) == s.charAt(index1) || p.charAt(index2) == '?')
            return solve(s, p, index1 - 1, index2 - 1);
        else if(p.charAt(index2) == '*') { // ***imp
            boolean takeEmptyChar = solve(s, p, index1, index2 - 1);
            boolean takeTheAboveChar = solve(s, p, index1 - 1, index2);
            return takeEmptyChar || takeTheAboveChar;
        } else {
            return false;
        }
    }

    private boolean solveMemo(String s, String p, int index1, int index2, int[][] dp) {
        if(index1 < 0 && index2 < 0)
            return true;

        if(index1 >= 0 && index2 < 0)
            return false;

        // **** imp
        if(index1 < 0 && index2 >= 0) {
            for(int i = 0; i <= index2; i++) {
                if(p.charAt(i) != '*')
                    return false;
            }
            return true;
        }

        if(dp[index1][index2] != -1)
            return dp[index1][index2] == 1;


        if(p.charAt(index2) == s.charAt(index1) || p.charAt(index2) == '?') {
            dp[index1][index2] = solveMemo(s, p, index1 - 1, index2 - 1, dp) ? 1 : 0;
            return dp[index1][index2] == 1;
        } else if(p.charAt(index2) == '*') { // ***imp
            boolean takeEmptyChar = solveMemo(s, p, index1, index2 - 1, dp);
            boolean takeTheAboveChar = solveMemo(s, p, index1 - 1, index2, dp);
            dp[index1][index2] = (takeEmptyChar || takeTheAboveChar) ? 1 : 0;
            return dp[index1][index2] == 1;
        } else {
            return dp[index1][index2] == 1;
        }
    }

    private boolean solveTab(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        dp[0][0] = 1;

        for(int j = 1; j <= p.length(); j++) {
            int flag = 1;
            for(int i = 1; i <= j; i++) {
                if(p.charAt(i - 1) != '*') {
                    flag = 0;
                    break;
                }
            }
            dp[0][j] = flag;
        }

        for(int index1 = 1; index1 <= s.length(); index1++) {
            for(int index2 = 1; index2 <= p.length(); index2++) {
                if(p.charAt(index2 - 1) == s.charAt(index1 - 1) || p.charAt(index2 - 1) == '?') {
                    dp[index1][index2] = dp[index1 - 1][index2 - 1];
                } else if(p.charAt(index2 - 1) == '*') { // ***imp
                    int takeEmptyChar = dp[index1][index2 - 1];
                    int takeTheAboveChar = dp[index1 - 1][index2];
                    dp[index1][index2] = (takeEmptyChar == 1 || takeTheAboveChar == 1)? 1 : 0;
                } else {
                    dp[index1][index2] = 0;
                }
            }
        }
        return dp[s.length()][p.length()] == 1;

    }
}
