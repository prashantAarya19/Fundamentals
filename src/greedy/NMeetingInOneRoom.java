package greedy;

import graph.problems.Pair;

import java.util.ArrayList;
import java.util.List;

class Pair2 {
    int startTime;
    int endTime;
    public Pair2(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
public class NMeetingInOneRoom {
    public static void main(String[] args) {

    }

    public static int maxMeetings(int start[], int end[], int n) {
        List<Pair2> meetingInterval = new ArrayList<>();
        for(int i = 0; i < start.length; i++) {
            meetingInterval.add(new Pair2(start[i], end[i]));
        }

        meetingInterval.sort((i1, i2) -> Integer.compare(i1.endTime, i2.endTime));

        int endTime = meetingInterval.get(0).endTime;
        int meetingCount = 1;

        for(int i = 1; i < meetingInterval.size(); i++) {
            if(meetingInterval.get(i).startTime > endTime) {
                ++meetingCount;
                endTime = meetingInterval.get(i).endTime;
            }

        }
        return meetingCount;
    }
}
