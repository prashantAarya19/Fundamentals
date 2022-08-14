package heap.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.add(5);
        pq.add(10);
        pq.add(8);
        pq.add(15);

        pq.forEach(e -> System.out.print(e +" "));
        
        int i = pq.peek();
        System.out.println(i);
    }
}
