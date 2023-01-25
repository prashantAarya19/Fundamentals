package dp;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        return solve(word1, word2, 0, 0);
    }

    private int solve(String word1, String word2, int index1, int index2) {
        if(index2 == word2.length())
            return word1.length() - index2;
        if(index1 == word1.length())
            return word2.length() - index1;

        if(word1.charAt(index1) == word2.charAt(index2)) {
            return solve(word1, word2, index1 + 1, index2 + 1);
        } else {
            int insert = 1 + solve(word2.charAt(index2)+word1, word2, index1+1, index2 + 1);
            int delete = 1 + solve(word1.substring(1), word2, index1, index2);
            int replace = 1 + solve(word2.charAt(index2)+(word1.substring(1)), word2, index1+1, index2 + 1);

            return Math.min(insert, Math.min(delete, replace));
        }
    }

    private int solveMemo(String word1, String word2, int index1, int index2, int[][] dp) {
        if(index2 == word2.length())
            return word1.length() - index1;
        if(index1 == word1.length())
            return word2.length() - index2;

        if(dp[index1][index2] != -1)
            return dp[index1][index2];

        if(word1.charAt(index1) == word2.charAt(index2)) {
            return dp[index1][index2] = solveMemo(word1, word2, index1 + 1, index2 + 1, dp);
        } else {
            int insert = 1 + solveMemo(word1, word2, index1, index2 + 1, dp);
            int delete = 1 + solveMemo(word1, word2, index1 + 1, index2, dp);
            int replace = 1 + solveMemo(word1, word2, index1+1, index2 + 1, dp);
            return dp[index1][index2] = Math.min(insert, Math.min(delete, replace));
        }
    }

    private int solveTab(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 0; i < word2.length(); i++) {
            dp[word1.length()][i] = word2.length() - i;
        }

        for(int i = 0; i < word1.length(); i++) {
            dp[i][word2.length()] = word1.length() - i;
        }

        for(int index1 = word1.length() - 1; index1 >= 0; index1--) {
            for(int index2 = word2.length() - 1; index2 >= 0; index2--) {
                if(word1.charAt(index1) == word2.charAt(index2)) {
                    dp[index1][index2] = dp[index1 + 1][index2 + 1];
                } else {
                    int insert = 1 + dp[index1][index2 + 1];
                    int delete = 1 + dp[index1 + 1][index2];
                    int replace = 1 + dp[index1+1][index2 + 1];
                    dp[index1][index2] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[0][0];
    }

    private int solve(String word1, String word2) {
        int[] next = new int[word2.length() + 1];
        // imp
        for(int i = 0; i < word2.length(); i++) {
            next[i] = word2.length() - i;
        }

        for(int index1 = word1.length() - 1; index1 >= 0; index1--) {
            int[] current = new int[word2.length() + 1];
            current[word2.length()] = word1.length() - index1;
            for(int index2 = word2.length() - 1; index2 >= 0; index2--) {
                if(word1.charAt(index1) == word2.charAt(index2)) {
                    current[index2] = next[index2 + 1];
                } else {
                    int insert = 1 + current[index2 + 1];
                    int delete = 1 + next[index2];
                    int replace = 1 + next[index2 + 1];
                    current[index2] = Math.min(insert, Math.min(delete, replace));
                }
            }
            next = current;
        }

        return next[0];
    }
}
