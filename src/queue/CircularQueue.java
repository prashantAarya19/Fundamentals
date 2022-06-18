package queue;

public class CircularQueue {
    private final int[] queue;
    private int front;
    private int rear;
    private final int size;

    public CircularQueue(int n) {
        this.size = n;
        this.queue = new int[size];
        this.rear = -1;
        this.front = -1;
    }

    public boolean enqueue(int value) {
        // Queue is full
        if(rear == size - 1 && front == 0 || rear == (front - 1) % (size - 1))
            return false;
        else if(rear == size - 1 && front != 0)
            rear = 0;
        else if(rear == -1 && front == -1) // queue is empty
            front = rear = 0;
        else
            rear++;
        queue[rear] = value;
        return true;
    }

    /*
      Dequeues top element from queue. Returns -1 if the stack is empty, otherwise
      returns the popped element.
    */
    public int dequeue() {
        if(front == -1)
            return -1;
        int elm = queue[front];
        queue[front] = -1;
        if(front == rear) {
            front = rear = -1;
        } else if(front == size - 1) {
            front = 0;
        } else {
            front++;
        }
        return elm;
    }

    public int peek() {
        if(front > rear)
            return -1;
        return queue[front];
    }
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(3);
        System.out.println(queue.enqueue(2));
        System.out.println(queue.enqueue(3));
        System.out.println(queue.dequeue());
        System.out.println(queue.enqueue(4));
        System.out.println(queue.enqueue(6));
        System.out.println(queue.enqueue(7));
        System.out.println(queue.dequeue());
    }
}
