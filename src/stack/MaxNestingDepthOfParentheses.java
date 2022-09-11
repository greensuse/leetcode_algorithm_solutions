package stack;

import java.util.Stack;

public class MaxNestingDepthOfParentheses {
    public int maxDepth(String s) {
        int max_depth=0;
        Stack<Character> stack=new Stack<>();
        for(char c : s.toCharArray()) {
            if(c==')') {
                if(stack.peek()=='(') {
                    stack.pop();
                }
            } else if(c=='(') {
                stack.push('(');
                if(stack.size()>max_depth) {
                    max_depth=stack.size();
                }
            }
        }
        return max_depth;
    }
}
