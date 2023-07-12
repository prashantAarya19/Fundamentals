package love50.string;

public class WildCardMatch {
    public static void main(String[] args) {
        String wild = "ge?ks*";
        String pattern = "geeksforgeeks";
        System.out.println(match(wild, pattern));
        char[] map1 = new char[26];
        System.out.println(map1[0] == 0);
    }
    private static boolean solve(String wild, String pattern, int wInd, int pInd) {
        if(wInd < 0 && pInd < 0)
            return true;

        if(wInd < 0)
            return false;

        if(pInd < 0) {

            for(int i = 0; i <= wInd; i++)
                if(wild.charAt(i) != '*')
                    return false;

            return true;
        }

        if(wild.charAt(wInd) == pattern.charAt(pInd) || wild.charAt(wInd) == '?')
            return solve(wild, pattern, wInd - 1, pInd - 1);
        else if(wild.charAt(wInd) == '*')
            return solve(wild, pattern, wInd - 1, pInd) || solve(wild, pattern, wInd, pInd - 1);
        else
            return false;

    }
    static boolean match(String wild, String pattern)
    {
        return solve(wild, pattern, wild.length() - 1, pattern.length() - 1);
    }
}
