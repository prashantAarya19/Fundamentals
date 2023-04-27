package love50.string;

public class KnuthMorrisAlgo {
    public static void main(String[] args) {
        String s = "abab";
        /*
        a b
        ab ab
        aba bab
         */
        String s1 = printAllSubsequence(s, 0, "", "");
        System.out.println(s1);
//        System.out.println(solve(s, 0));
    }

    private static String solve(String s, int start) {
        if(start == s.length() - 1)
            return "";
        String result = "";
        String prefix = s.charAt(start) + solve(s, start + 1);
        String suffix = "";
        suffix = s.charAt(start + 1) + suffix;

        if(prefix.equals(suffix))
            result = prefix;
        return result;
    }

    private static String printAllSubsequence(String s, int start, String suffix, String prefix) {
        if(start == s.length())
            return "";

//        System.out.println("suffix : " + suffix);
//        System.out.println("prefix : " + prefix);
          String result = "";
          if(!prefix.equals("") && prefix.equals(suffix))
              result = printAllSubsequence(s, start + 1, suffix + s.charAt(start), s.charAt(s.length() - 1 - start) + prefix);
          return result;
    }
}
