package list;

public class FlattenMultilevelDoublyLinkedList_1 {
    public Node flatten(Node head) {
        Node p=head;
        while(p!=null) {
            if(p.child!=null) {
                mergeChild(p, p.child, p.next);
            } else {
                p=p.next;
            }
        }
        return head;
    }

    private void mergeChild(Node prev, Node child, Node next) {
        Node p=prev, c=child;
        child.prev=prev;
        while(c!=null) {
            p.next=c;
            p=c;
            if(c.child!=null) {
                mergeChild(c, c.child, c.next);
            }
            c=c.next;

        }
        p.next=next;
        if(next!=null) {
            next.prev=p;
        }
        prev.child=null;
    }

    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
