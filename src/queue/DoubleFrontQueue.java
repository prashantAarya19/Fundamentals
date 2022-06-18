package queue;

import java.util.Deque;

public class DoubleFrontQueue {
    private final int[] queue;
    private final int size;
    private int front;
    private int rear;

    public DoubleFrontQueue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean addFront(int val) {
        if(isFull())
            return false;
        else if(front == -1 && rear == -1)
            front = rear = 0;
        else if(front == 0)
            front = size - 1;
        else
            front--;
        queue[front] = val;
        return true;
    }

    public boolean addRear(int val) {
        if(isFull())
            return false;
        else if (front == -1 && rear == -1)
            front = rear = 0;
        else if (rear == size - 1 && front != 0)
            rear = 0;
        else
            rear++;
        queue[rear] = val;
        return true;
    }

    public int removeFront() {
        if(isEmpty())
            return -1;
        int val = queue[front];
        queue[front] = -1;
        if(front == rear)
            front = rear = -1;
        else if(front == size -1)
            front = 0;
        else
            front++;
        return val;
    }
    public int removeRear() {
        if(isEmpty())
            return -1;
        int val = queue[rear];
        queue[rear] = -1;
        if(front == rear)
            front = rear = -1;
        else if(rear == 0)
            rear = size - 1;
        else
            rear--;
        return val;
    }

    public boolean isFull() {
        return (rear == size - 1 && front == 0 || rear != 0 && rear == (front - 1) % (size - 1));
    }
}
