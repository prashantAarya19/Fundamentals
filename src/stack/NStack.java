package stack;

import java.util.Arrays;

public class NStack {
    int[] stack;
    int[] next;
    int[] top;
    int emptySpace;
    int n;
    int s;

    /*
    n -> number of stacks
    s -> size of an array
     */
    public NStack(int n, int s) {
        this.stack = new int[s];
        this.next = new int[s];
        this.top = new int[n];
        this.n = n;
        this.s = s;
        this.emptySpace = 0;

        // initialize top
        Arrays.fill(top, -1);
        // initialize next
        for(int i = 0; i < s; i++) {
            next[i] = i + 1;
        }
        next[s-1] = -1;
    }

    /*
    x -> data to inserted
    m -> stack
    (Pop from which stack)
     */
    public boolean push(int x, int m) {
        if(emptySpace == -1)
            return false;
        // get empty space
        int index = emptySpace;
        // insert into empty space
        this.stack[index] = x;
        // update emptySpace
        this.emptySpace = this.next[index];
        // update next
        this.next[index] = this.top[m - 1];
        // update top
        this.top[m - 1] = index;
        return true;
    }

    /*
    m -> stack
    (Pop from which stack)
     */
    public int pop(int m) {
       if(this.top[m-1] == -1) {
           return -1;
       }
       int index = this.top[m - 1];
       this.top[m - 1] = this.next[index];
       this.next[index] = this.emptySpace;
       emptySpace = index;
       return stack[index];
    }
    public static void main(String[] args) {
        NStack stack = new NStack(1, 1);
        stack.push(2, 1);
        stack.push(3, 1);
        System.out.println(stack.stack[1]);
        System.out.println(stack.push(5, 1));
    }
}
