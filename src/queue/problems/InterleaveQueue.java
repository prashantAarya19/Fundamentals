package queue.problems;

import java.util.LinkedList;
import java.util.Queue;

public class InterleaveQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(10);
        queue.add(9);
        getInterleave(queue);
        System.out.println(queue);
    }

    /*
    Input:    1 2 3 4
    Output : 1 3 2 4
     */
    private static void getInterleave(Queue<Integer> queue) {
        int mid = queue.size() / 2;
        Queue<Integer> tempQ = new LinkedList<>();
        while(mid > 0) {
            tempQ.add(queue.peek());
            queue.remove();
            --mid;
        }
        while(!tempQ.isEmpty()) {
            if(queue.isEmpty()) break;
            int val1 = tempQ.peek();
            int val2 = queue.peek();
            tempQ.remove();
            queue.remove();
            queue.add(val1);
            queue.add(val2);
        }
    }
}
