package love50.string;

public class RemoveConsicutiveChar {
    public static void main(String[] args) {
        String s = "";
        System.out.println(removeConsecutiveCharacter(s));

    }
    private static String solve(String S, int start, String result) {
        if(start == S.length())
            return result;

        if(result.length() == 0 || result.charAt(result.length() - 1) != S.charAt(start)) {
            return solve(S, start + 1, result + S.charAt(start));
        } else {
            return solve(S, start + 1, result);
        }
    }
    public static String removeConsecutiveCharacter(String S){
        return solve(S, 0, "");
    }
}
