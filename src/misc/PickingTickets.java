package misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PickingTickets {
    public static int pickLongestSegment(List<Integer> tickets) {
        Collections.sort(tickets);
        int s = 1;
        int result = 0;
        List<Integer> resultList = new ArrayList<>();
        while(s < tickets.size()) {
            int temp = s - 1;
            int diff = tickets.get(s) - tickets.get(temp);

            if(diff == 0 || diff == 1) {
                ++result;
            } else {
                resultList.add(result);
                result = 0;
            }
            ++s;
        }
        return resultList.get(resultList.size()-1);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(4);
        list.add(13);
        list.add(2);
        list.add(3);

        System.out.println(pickLongestSegment(list));
    }

}
