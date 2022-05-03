package arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TimeToBuyTicket {

    public static void main(String[] args) {
        boolean[] i = new boolean[10];
        Arrays.fill(i, true);
        i[0] = i[1] = false;
        System.out.println(Arrays.toString(i));
    }
}
