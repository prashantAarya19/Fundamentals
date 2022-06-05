package stack;

public class ArrayStack {
    private final int[] stack;
    private int top;
    private final int size;

    public ArrayStack(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    public void push(int data) {
        if(top >= size-1) {
            throw new StackOverflowError("Stack is full");
        }
        stack[++top] = data;
    }

    public void pop() {
        if(top == -1) {
            throw new NullPointerException("Stack is empty");
        }
        stack[top--] = 0;
    }

    public int size() {
        return top;
    }

    public int peek() {
        if(top == -1) {
            throw new NullPointerException("Stack is empty");
        }
        return stack[top];
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
