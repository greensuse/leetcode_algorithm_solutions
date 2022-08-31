package array_string;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjacentDuplicates {
    public static void main(String[] args) {
        String s="deeedbbcccbdaa";
        String res=new RemoveAllAdjacentDuplicates().removeDuplicates(s, 3);
        System.out.println(res);
    }
    public String removeDuplicates(String s, int k) {
        if(s==null && s.length()<k) return s;

        Deque<Node> stack=new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(stack.isEmpty() || stack.peek().c!=c) {
                stack.push(new Node(c));
            } else {
                if(stack.peek().times+1==k) {
                    stack.pop();
                } else {
                    stack.peek().times++;
                }
            }
        }

        StringBuilder sb=new StringBuilder();

        while(!stack.isEmpty()) {
            Node node = stack.pop();
            for(int i=0; i<node.times; i++) {
                sb.append(node.c);
            }
        }

        return sb.reverse().toString();
    }

    class Node {
        char c;
        int times;
        public Node(char c) {
            this.c=c;
            this.times=1;
        }
    }
}
