package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<>();
        for(String s: tokens) {
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")) {
                int right=Integer.valueOf(stack.pop());
                int left=Integer.valueOf(stack.pop());
                if(s.equals("+")) {
                    stack.push(String.valueOf(left+right));
                } else if(s.equals("+")) {
                    stack.push(String.valueOf(left+right));
                } else if(s.equals("-")) {
                    stack.push(String.valueOf(left-right));
                } else if(s.equals("*")) {
                    stack.push(String.valueOf(left*right));
                } else if(s.equals("/")) {
                    stack.push(String.valueOf(left/right));
                }
            } else {
                stack.push(s);
            }

        }
        return Integer.valueOf(stack.pop());
    }
}
