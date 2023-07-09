package love50.string;

public class MinCharToMakePalindrome {
    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(minChar(s));
    }
    public static int minChar(String str) {
        int i = 0;
        int j = str.length() - 1;
        int last = j;
        int res = 0;
        while(i < j) {
            if(str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                res++;

                i = 0;
                j = --last;
            }
        }
        return res;
    }
}
