package greedy;

import java.util.PriorityQueue;

public class MinCostOfRopes {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
    }

    long minCost(long arr[], int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        long minCost = 0;
        while(pq.size() > 1) {
            long currentJoin = pq.remove() + pq.remove();
            minCost += currentJoin;
            pq.add(currentJoin);
        }
        return minCost;
    }
}
