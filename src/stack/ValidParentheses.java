package stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c: s.toCharArray()) {
            if(c==')' || c=='}' || c==']') {
                if(stack.isEmpty()) return false;
                if(c==')' && stack.peek()=='(') {
                    stack.pop();
                } else  if(c=='}' && stack.peek()=='{') {
                    stack.pop();
                }  else  if(c==']' && stack.peek()=='[') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        if(stack.isEmpty()) return true;
        else return false;
    }
}
