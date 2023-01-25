package greedy;

public class ReverseWords {
    //Function to reverse words in a given string.
    String reverseWords(String S) {

        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for(int i = S.length() - 1; i >= 0; i--) {
            if(S.charAt(i) != '.') {
                word.append(S.charAt(i));
            } else {
                result.append(reverse(word.toString())).append(".");
                word = new StringBuilder();
            }
        }
        result.append(reverse(word.toString()));
        return result.toString();

    }

    String reverse(String s) {
        StringBuilder rev = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            rev.append(s.charAt(i));
        }
        return rev.toString();
    }
}
