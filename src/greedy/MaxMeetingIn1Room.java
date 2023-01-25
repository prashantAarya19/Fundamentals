package greedy;

import java.util.ArrayList;
import java.util.List;

class Pair3 {
    int startTime;
    int endTime;
    int originalIndex;

    public Pair3(int startTime, int endTime, int originalIndex) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.originalIndex = originalIndex;
    }
}
public class MaxMeetingIn1Room {
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        List<Pair3> sortedList  = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            sortedList.add(new Pair3(S[i], F[i], i + 1));
        }

        sortedList.sort((e1, e2) -> {
            if(e1.startTime == e2.startTime)
                return e1.originalIndex - e2.originalIndex;
            else
                return e1.endTime - e2.endTime;

        });

        ArrayList<Integer> result = new ArrayList<>();
        result.add(sortedList.get(0).originalIndex);
        int prev = 0;
        for(int i = 1; i < sortedList.size(); i++) {
            if(sortedList.get(prev).endTime < sortedList.get(i).startTime) {
                result.add(sortedList.get(i).originalIndex);
                prev = i;
            }
        }
        result.sort((r1, r2) -> r1 - r2);
        return result;
    }

    public static ArrayList<Integer> maxMeetings2(int N, int[] S, int[] F) {
        List<Pair3> sortedList  = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            sortedList.add(new Pair3(S[i], F[i], i + 1));
        }

        sortedList.sort((e1, e2) -> e1.endTime - e2.endTime);

        ArrayList<Integer> result = new ArrayList<>();
        result.add(sortedList.get(0).originalIndex);
        int prev = sortedList.get(0).endTime;
        for(int i = 1; i < sortedList.size(); i++) {
            if(prev < sortedList.get(i).startTime) {
                result.add(sortedList.get(i).originalIndex);
                prev = sortedList.get(i).endTime;
            }
        }
        result.sort((r1, r2) -> r1 - r2);
        return result;
    }
}
