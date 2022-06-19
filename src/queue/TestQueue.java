package queue;

import java.util.*;

public class TestQueue {
    public static void main(String[] args) {
//        Queue<Integer> queue = new PriorityQueue<>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        System.out.println(queue);
//        queue.remove();
//        queue.offer(4);
//        System.out.println(queue);
//        System.out.println(queue.peek());
//        System.out.println(queue.element());
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(3);
        dq.addFirst(4);
        System.out.println(dq.size());

    }
}
