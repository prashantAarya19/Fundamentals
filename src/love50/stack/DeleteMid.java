package love50.stack;

import java.util.Stack;

public class DeleteMid {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(10);
        stack.add(20);
        stack.add(30);
        stack.add(40);
        int mid = stack.size() / 2;
        solve(stack, mid, 0);
        System.out.println(stack);
    }

    private static void solve(Stack<Integer> stack, int mid, int ind) {
        if(ind == mid) {
            stack.pop();
            return;
        }

        int temp = stack.pop();
        solve(stack, mid, ind + 1);
        stack.push(temp);
    }

}
