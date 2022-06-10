package stack;

public class MinStack_1 {

    private Node[] nodes=null;
    private int size=0;

    public MinStack_1() {
        nodes=new Node[30000];
    }

    public void push(int val) {
        Node node = new Node(val);
        if(size==0) {
            node.min=val;
            nodes[0]=node;
            size=1;
        } else {
            node.min=val>nodes[size-1].min?nodes[size-1].min:val;
            nodes[size]=node;
            size++;
        }
    }

    public void pop() {
        if(size>0) {
            nodes[size-1]=null;
            size--;
        }
    }

    public int top() {
        if(size>0) {
            return nodes[size-1].val;
        } else {
            return 0;
        }
    }

    public int getMin() {
        if(size>0) {
            return nodes[size-1].min;
        } else {
            return 0;
        }
    }

    private class Node {
        int val, min;
        Node(int val) {
            this.val=val;
        }

    }
}
