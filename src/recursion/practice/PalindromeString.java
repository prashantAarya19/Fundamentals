package recursion.practice;

public class PalindromeString {
    public static void main(String[] args) {
//        String s = "abbca";
        String s = "madam";
        System.out.println(solve(s, 0));
    }

    private static boolean solve(String s, int i) {
        if(i >= s.length() / 2)
            return true;

        if(s.charAt(i) == s.charAt(s.length() - i - 1))
            return solve(s, i + 1);
        return false;
    }
}
