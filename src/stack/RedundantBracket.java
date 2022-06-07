package stack;

import java.util.Stack;

public class RedundantBracket {
    public static void main(String[] args) {
        String s = "(a+c*b)(a*b)";
        System.out.println(isRedundant(s));
    }

    private static boolean isRedundant(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' ||
                    s.charAt(i) == '*' ||
                    s.charAt(i) == '+' ||
                    s.charAt(i) == '-' ||
                    s.charAt(i) == '/') {
                stack.push(s.charAt(i));
            } else {
                if(s.charAt(i) == ')' && !stack.isEmpty()) {
                    boolean isRedundant = true;
                    while(stack.peek() != '(') {
                        if( stack.peek() == '*' ||
                            stack.peek() == '+' ||
                            stack.peek() == '-' ||
                            stack.peek() == '/')
                            isRedundant = false;
                        stack.pop();
                    }
                    if(isRedundant) {
                        return true;
                    }
                    stack.pop();
                }
            }
        }
        return false;

    }
}
