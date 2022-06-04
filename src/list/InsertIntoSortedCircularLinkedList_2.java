package list;

public class InsertIntoSortedCircularLinkedList_2 {
    public Node insert(Node head, int insertVal) {
        if(head==null) {
            Node node= new Node(insertVal);
            node.next=node;
            return node;
        }

        Node prev=head, curr=head.next;
        do {
            if(prev.val<=insertVal && curr.val>=insertVal) {
                prev.next=new Node(insertVal);
                prev.next.next=curr;
                return head;
            } else if(prev.val>curr.val){
                if(insertVal<=curr.val || insertVal>=prev.val) {
                    prev.next=new Node(insertVal);
                    prev.next.next=curr;
                    return head;
                }
            }

            prev=curr;
            curr=curr.next;
        } while(prev!=head);


        Node node= new Node(insertVal);
        node.next=head.next;
        head.next=node;
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
