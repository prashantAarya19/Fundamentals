package love50.string;

import java.util.HashMap;
import java.util.Map;

public class AllPalindromicStrings {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(countPS(str));
    }

    private static boolean isPalindrome(String ss) {
        if(ss.isBlank())
            return false;
        for(int i = 0; i < ss.length(); i++) {
            if(ss.charAt(i) != ss.charAt(ss.length() - i - 1))
                return false;
        }
        return true;
    }

    static long solve(String str, int ind, String ss, Map<String, Long> dp) {
        if(ind == str.length()) {
            if(isPalindrome(ss)) {
                return 1;
            } else
                return 0;
        }

        String key = ind+"dp"+ss;
        if(dp.containsKey(key))
            return dp.get(key);

        long count = 0;
        count += solve(str, ind + 1, ss + str.charAt(ind), dp);
        count = (count % MOD);
        count += solve(str, ind + 1, ss, dp);
        count = (count % MOD);

        dp.put(key, count);
        return dp.get(key);
    }

    static long countPS(String str)
    {
        Map<String, Long> dp = new HashMap<>();
        return solve(str, 0, "", dp);
    }
}
