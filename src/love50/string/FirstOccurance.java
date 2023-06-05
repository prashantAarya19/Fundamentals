package love50.string;

public class FirstOccurance {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        int s1 = 0;
        int s2 = 0;
        /*
            s1 = 2 v
            s2 = 0

            s1 = 3 v
            s2 = 1

            s1 = 4
            s2 = 2
        */
        while(s1 < haystack.length() && s2 < needle.length()) {
            if(haystack.charAt(s1) == needle.charAt(s2)) {
                int temp1 = s1;
                while(s1 < haystack.length() && s2 < needle.length()) {
                    if(haystack.charAt(s1) == needle.charAt(s2)) {
                        s1++;
                        s2++;
                    } else {
                        s1 = temp1 + 1;
                        s2 = 0;
                        break;
                    }
                }
            } else {
                s1++;
            }
        }

        if(s2 == needle.length())
            return s1 - s2;
        else
            return -1;
    }
}
