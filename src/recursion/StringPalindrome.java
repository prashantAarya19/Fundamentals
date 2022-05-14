package recursion;

import org.w3c.dom.ls.LSOutput;

public class StringPalindrome {
    public static void main(String[] args) {
        String str = "ToTa";
        System.out.println(isPalindrome(str, 0, str.length() - 1));
    }

    private static boolean isPalindrome(String str, int s, int e) {
        if(str.charAt(s) != str.charAt(e))
            return false;

        if(s > e)
            return true;

        return isPalindrome(str, ++s, --e);
    }
}
