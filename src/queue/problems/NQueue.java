package queue.problems;

import org.w3c.dom.Node;

import java.util.Arrays;

public class NQueue {
    private int freeSpot;
    private final int[] queue;
    private final int[] next;
    private final int[] front;
    private final int[] rear;

    public NQueue(int n, int m) {
        this.queue = new int[n];
        this.front = new int[m];
        this.rear = new int[m];
        this.next = new int[n];
        this.freeSpot = 0;
        // Initialize next
        for (int i = 0; i < n; i++) {
            next[i] = i + 1;
        }
        // Initialize front
        Arrays.fill(front, -1);
        // Initialize rear
        Arrays.fill(rear, -1);
    }

    public boolean push(int data, int nQ) {
        if(freeSpot == -1)
            return false;
        // 1. Get free spot
        int index = freeSpot;
        // 2. Update free spot
        freeSpot = next[index];
        // 3. Update next
        next[index] = rear[nQ - 1]; // Pointing the next to current rear
        // 4. If we are inserting the first element
        if(front[nQ - 1] == -1) {
            rear[nQ - 1] = index;
            front[nQ - 1] = index;
        } else { // if Q already has some element point the rear to index where we are inserting the element
            rear[nQ - 1] = index;
        }
        // 5. Insert the data at free spot
        queue[index] = data;
        return true;
    }

    public int pop(int nQ) {
        if(front[nQ - 1] == -1)
            return -1;
        // 1. Get the index of front
        int index = front[nQ - 1];
        int elm = queue[index];
        // 2. Get the element from front
        int frontElm = queue[index];
        // 3. Remove the element from front
        queue[front[nQ - 1]] = -1;
        // 4. Update the front
        front[nQ - 1] = next[index];
        // 5. Update the next
        next[index] = freeSpot;
        // 6. Update the free spot
        freeSpot = index;
        return elm;
    }

    public static void main(String[] args) {
        NQueue q = new NQueue(4, 2);
        System.out.println(q.push(3, 1));
        System.out.println(q.pop(1));
        System.out.println(q.pop(1));
        System.out.println(q.push(5, 2));
        System.out.println(q.pop(2));
        System.out.println(q.pop(2));
    }

}
