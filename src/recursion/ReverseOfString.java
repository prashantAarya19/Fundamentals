package recursion;

public class ReverseOfString {
    public static void main(String[] args) {
        String s = "abc";
       // System.out.println(reverse(s));
        System.out.println(reverse2(s, 0, s.length() - 1));
    }

    private static String reverse(String str) {
       if(str.length() == 0) {
           return "";
       }
       return str.charAt(str.length() - 1)+ reverse(str.substring(0, str.length() - 1));
    }

    private static String reverse2(String str, int s, int e) {
        if(s == e) {
            return str.charAt(s)+"";
        }
        return str.charAt(e)+reverse2(str, s + 1, e - 1)+str.charAt(s);
    }
}