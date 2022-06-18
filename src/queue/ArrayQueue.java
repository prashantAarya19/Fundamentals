package queue;

public class ArrayQueue {
    int[] queue;
    int front;
    int rear;
    int size;

    public ArrayQueue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.rear = 0;
        this.front = 0;
    }

    public void add(int data) {
        if(rear > size)
            throw new ArrayIndexOutOfBoundsException("Queue is full");
        queue[rear++] = data;
    }

    public int remove() {
        if(front == rear)
            return -1;
       else {
           int temp = queue[front];
           queue[front++] = -1;
           if(front == rear) {
               front = 0;
               rear = 0;
           }
           return temp;
        }
    }

    public int peek() {
        if(front == rear)
            return -1;
        return queue[front];
    }

    public int size() {
        return rear;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(2);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue.peek());
    }
}
