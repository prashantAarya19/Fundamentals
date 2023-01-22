package dp;

public class LongesCommonSubsequence {
    public static void main(String[] args) {
        String s = "ab";
        System.out.println(s.charAt(1));
    }

    private int solve(String text1, String text2, int index1, int index2) {
        if(index1 == text1.length() || index2 == text2.length())
            return 0;

        if(text1.charAt(index1) == text2.charAt(index2))
            return 1 + solve(text1, text2, index1 + 1, index2 + 1);
        else
            return Math.max(solve(text1, text2, index1 + 1, index2),
                    solve(text1, text2, index1, index2 + 1));
    }

    private int solveTab(String text1, String text2, int index1, int index2, int[][] dp) {
        if(index1 == text1.length() || index2 == text2.length())
            return 0;
        if(dp[index1][index2] != -1)
            return dp[index1][index2];

        if(text1.charAt(index1) == text2.charAt(index2))
            return dp[index1][index2] = 1 + solveTab(text1, text2, index1 + 1, index2 + 1, dp);
        else
            return dp[index1][index2] = Math.max(solveTab(text1, text2, index1 + 1, index2, dp),
                    solveTab(text1, text2, index1, index2 + 1, dp));
    }
}
