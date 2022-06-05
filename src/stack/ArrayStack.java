package stack;

public class ArrayStack {
    private final int[] stack;
    private int peek;
    private final int size;

    public ArrayStack(int size) {
        this.size = size;
        this.stack = new int[size];
        this.peek = -1;
    }

    public void push(int data) {
        if(peek >= size-1) {
            throw new StackOverflowError("Stack is full");
        }
        stack[++peek] = data;
    }

    public void pop() {
        if(peek == -1) {
            throw new NullPointerException("Stack is empty");
        }
        stack[peek--] = 0;
    }

    public int size() {
        return peek;
    }

    public int peek() {
        if(peek == -1) {
            throw new NullPointerException("Stack is empty");
        }
        return stack[peek];
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
//        stack.push(1);
//        stack.push(3);
//        stack.push(4);

        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}
