package love50.string;

import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString {
    public static void main(String[] args) {
        String a = "aab";
        System.out.println(reorganizeString(a));
    }
    static class Pair {
        int frequency;
        char charVal;

        public Pair(int frequency, char charVal) {
            this.frequency = frequency;
            this.charVal = charVal;
        }
    }
    public static String reorganizeString(String s) {
        int[] frequency = new int[26];
        String result = "";

        for(int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        Queue<Pair> pq = new PriorityQueue<>((e1, e2) -> e2.frequency - e1.frequency);

        for(char i = 'a'; i <= 'z'; i++) {
            if(frequency[i - 'a'] > 0)
                pq.add(new Pair(frequency[i - 'a'], i));
        }

        Pair prev = new Pair(-1, '#');
        while(!pq.isEmpty()) {
            Pair p = pq.remove();

            result += p.charVal;

            if(prev.frequency > 0) {
                pq.add(prev);
            }

            (p.frequency)--;
            prev = p;
        }

        if(result.length() == s.length())
            return result;
        else
            return "";
    }
}
