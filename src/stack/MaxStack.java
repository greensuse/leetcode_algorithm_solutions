package stack;

import java.util.*;

public class MaxStack {
    private TreeMap<Integer, List<Node>> map;
    private DoubleLinkedList dll;

    public MaxStack() {
        map=new TreeMap<>();
        dll=new DoubleLinkedList();
    }

    public void push(int x) {
        Node node = dll.add(x);
        List<Node> nodes=map.getOrDefault(x, new ArrayList<Node>());
        nodes.add(node);
        map.put(x, nodes);

    }

    public int pop() {
        int val = dll.pop();
        List<Node> l = map.get(val);
        l.remove(l.size()-1);
        if(l.isEmpty()) {
            map.remove(val);
        }
        return val;
    }

    public int top() {
        return dll.peek();
    }

    public int peekMax() {
       return map.lastKey();
    }

    public int popMax() {
        int val=peekMax();
        List<Node> l = map.get(val);
        Node node = l.remove(l.size()-1);
        if(l.isEmpty()) {
            map.remove(val);
        }
        dll.unlink(node);
        return val;
    }
}

class DoubleLinkedList {
    Node head, tail;

    DoubleLinkedList() {
        head=new Node(0);
        tail=new Node(0);
        head.next=tail;
        tail.prev=head;
    }

    public Node add(int val) {
        Node node = new Node(val);
        node.next=tail;
        tail.prev.next=node;
        node.prev=tail.prev;
        tail.prev=node;

        return node;
    }

    public int pop() {
        Node node = tail.prev;
        unlink(node);
        return node.val;
    }

    public int peek() {
        return tail.prev.val;
    }

    public Node unlink(Node node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;
        return node;
    }
}

class Node {
    int val;
    Node prev, next;
    Node(int val) {this.val=val;}
}
