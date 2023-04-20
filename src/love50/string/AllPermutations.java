package love50.string;

import java.util.*;

public class AllPermutations {
    public static List<String> find_permutation(String S) {
        List<String> result = new ArrayList<>();
        boolean[] visited = new boolean[S.length()];
        solve(S, result, visited, "");
        return result;
    }

    private static void solve(String str, List<String> result, boolean[] visited, String perm) {
        if(perm.length() == str.length()) {
            result.add(perm);
            return;
        }

        for(int i = 0; i < str.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                solve(str, result, visited, perm + str.charAt(i));
                visited[i] = false;
                // perm.substring(0, str.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "ABC";
        System.out.println(find_permutation(s));
    }
}
