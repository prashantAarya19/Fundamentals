package love50.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoyerMoorAlgo {
    static final int MAX_CHARS = 256;

    private static void createPatternArray(int[] patArr, char[] pattern) {
        Arrays.fill(patArr, -1);
        for(int i = 0; i < pattern.length; i++) {
            patArr[pattern[i]] = i;
        }
    }

    private static List<Integer> findPattern(char[] text, char[] pattern) {
        List<Integer> result = new ArrayList<>();

        int textLen = text.length;
        int patternLen = pattern.length;

        int[] patArr = new int[MAX_CHARS];
        createPatternArray(patArr, pattern);

        int s = 0;

        while(s <= (textLen - patternLen)) {
            int j = patternLen - 1;
            while(j >= 0 && pattern[j] == text[s + j])
                j--;

            if(j < 0) {
                result.add(s);
                // to find next pattern we have to put s to next word.
                s += (s + patternLen < textLen) ? patternLen - patArr[text[s + patternLen]] : 1;
            } else {
                // to find the index of remaining bad character. bad char doesn't present shift the s to just next index.
                s += Math.max(1, j - patArr[text[s + j]]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[] text = "aacabc".toCharArray();
        char[] pattern = "ab".toCharArray();
        System.out.println(findPattern(text, pattern));
        /*
        adcabc
          ab
        * */
    }
}
