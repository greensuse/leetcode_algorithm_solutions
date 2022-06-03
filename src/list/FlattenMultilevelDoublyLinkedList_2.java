package list;

import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenMultilevelDoublyLinkedList_2 {

    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        Node node7=new Node(7);
        Node node8=new Node(8);
        Node node9=new Node(9);
        Node node10=new Node(10);
        Node node11=new Node(11);
        Node node12=new Node(12);

        node1.next=node2;
        node2.prev=node1;
        node2.next=node3;
        node3.prev=node2;
        node3.child=node7;
        node3.next=node4;
        node4.prev=node3;
        node4.next=node5;
        node5.prev=node4;
        node5.next=node6;
        node6.prev=node5;

        node7.next=node8;
        node8.prev=node7;
        node8.next=node9;
        node9.prev=node8;
        node9.next=node10;
        node10.prev=node9;

        node8.child=node11;
        node11.next=node12;
        node12.prev=node11;

        Node result = flatten(node1);
    }

    public static Node flatten(Node head) {
        if (head == null) return head;

        Node pseudoHead = new Node(0, null, head, null);
        Node curr, prev = pseudoHead;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;

            if (curr.next != null) stack.push(curr.next);
            if (curr.child != null) {
                stack.push(curr.child);
                // don't forget to remove all child pointers.
                curr.child = null;
            }
            prev = curr;
        }
        // detach the pseudo node from the result
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int _val) {val=_val;}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };
}
