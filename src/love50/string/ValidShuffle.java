package love50.string;

import java.util.Arrays;

public class ValidShuffle {
    public static void main(String[] args) {
        String s1 = "XY";
        String s2 = "12";
        String shuffle = "2YX1";

        System.out.println(isValidShuffle(s1, s2, shuffle));
    }

    private static boolean isValidShuffle(String s1, String s2, String shuffle) {
        s1 = sort(s1);
        s2 = sort(s2);
        shuffle = sort(shuffle);

        int i1 = 0, i2 = 0, r = 0;

        while(r < shuffle.length()) {
            if(i1 < s1.length() && s1.charAt(i1) == shuffle.charAt(r))
                i1++;
            else if(i2 < s2.length() && s2.charAt(i2) == shuffle.charAt(r))
                i2++;
            else
                return false;
            r++;
        }

        return i1 >= s1.length() && i2 >= s2.length();
    }

    private static String sort(String s1) {
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

}
