package love50.string;

public class Lps {
    public static void main(String[] args) {
        String s = "abc";

        //
//        System.out.println(s.substring(0, s.length() - 1));
        System.out.println(s.isBlank());
    }
    private static int lps(String s) {
        int[] arr = new int[s.length()];

        int i1 = 0;
        int i2 = 1;

        while(i2 < s.length()) {
            if(s.charAt(i1) == s.charAt(i2)) {
                i1++;
                arr[i2] = i1;
                i2++;
            } else {
                if(i1 != 0) {
                    i1 = arr[i1 - 1];
                } else {
                    i2++;
                }
            }
        }
        return arr[i2 - 1];
    }
}
