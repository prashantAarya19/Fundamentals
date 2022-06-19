package queue.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ReverseFirstKElement {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        if(k > q.size()) {
            return q;
        }
        q = reverse(q, k, 1);
        for(int i = 0; i < q.size() - k; i++) {
            int temp = q.peek();
            q.remove();
            q.add(temp);
        }
        return q;
    }

    public Queue<Integer> reverse(Queue<Integer> q, int k, int i) {
        if(i > k) {
            return q;
        }

        Queue<Integer> tempQ = q;
        int temp = tempQ.peek();
        tempQ.remove();
        q = reverse(tempQ, k, i+1);
        q.add(temp);
        return q;
    }
}
