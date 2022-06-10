package stack;

import java.util.Stack;

public class MinStack_2 {

    public static void main(String[] args) {
        MinStack_2 minStack = new MinStack_2();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);

        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    private Stack<Integer> valStack=new Stack<>();
    private Stack<Integer> minStack=new Stack<>();

    public void push(int val) {
        valStack.push(val);
        if(minStack.isEmpty() || val<=minStack.peek().intValue()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (!valStack.isEmpty()) {
            if(valStack.peek().intValue()==minStack.peek().intValue()) {
                minStack.pop();
            }
            valStack.pop();
        }
    }

    public int top() {
        return valStack.peek();
    }

    public int getMin() {
        return minStack.peek();

    }
}
