package list;

public class InsertIntoSortedCircularLinkedList_1 {
    public Node insert(Node head, int insertVal) {
        if(head==null) {
            Node node= new Node(insertVal);
            node.next=node;
            return node;
        }

        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;

        Node p=head;
        while(p!=null) {
            if(p.val<=insertVal && p.next.val>=insertVal) {
                Node temp = p.next;
                p.next=new Node(insertVal);
                p.next.next=temp;
                break;
            } else {
                if(p.val==max && p.next.val==min) {
                    //finished 1 circle
                    Node temp = p.next;
                    p.next=new Node(insertVal);
                    p.next.next=temp;
                    break;
                }

                if(p.val<min) {
                    min=p.val;
                }
                if(p.val>max) {
                    max=p.val;
                }

                p=p.next;
            }
        }

        return head;
    }

    private class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
}
