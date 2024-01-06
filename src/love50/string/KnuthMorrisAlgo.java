package love50.string;

import java.util.ArrayList;
import java.util.List;

public class KnuthMorrisAlgo {
    public static void main(String[] args) {
        String s = "abab";
        /*
        a b
        ab ab
        aba bab
         */
        String pattern = "ab";
        List<Integer> search = search(s, pattern);
        System.out.println(search);
//        System.out.println(solve(s, 0));
    }

    static List<Integer> search(String pat, String s)
    {
        int[] lps = getLps(pat);
        int sourceInd = 0, patInd = 0;
        List<Integer> list = new ArrayList<>();
        while(sourceInd < s.length() && patInd < pat.length()) {
            if(s.charAt(sourceInd) == pat.charAt(patInd)) {
                sourceInd++;
                patInd++;
            } else {
                if(patInd != 0) {
                    patInd = lps[patInd - 1];
                } else {
                    sourceInd++;
                }
            }

            if(patInd == pat.length()){
                list.add(sourceInd - patInd + 1);
                patInd = lps[patInd - 1];
            }
        }

        if(list.isEmpty())
            list.add(-1);
        return list;
    }

    private static int[] getLps(String pat) {
        int[] lps = new int[pat.length()];

        int left = 0, right = 1;

        while(right < pat.length()) {
            if(pat.charAt(left) == pat.charAt(right)) {
                lps[right++] = ++left;
            } else {
                if(left != 0) {
                    left = lps[left - 1];
                } else {
                    right++;
                }
            }

        }
        return lps;
    }
}
