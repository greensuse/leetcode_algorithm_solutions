package list;

import org.w3c.dom.Node;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        //step 1, copy and weave nodes
        Node p=head;
        while(p!=null) {
            Node newNode = new Node(p.val);
            newNode.next=p.next;
            p.next=newNode;
            p=p.next.next;
        }

        //step 2, set random pointer
        p=head;
        while(p!=null && p.next!=null) {
            p.next.random=p.random!=null?p.random.next:null;
            p=p.next.next;
        }

        //step3, unweave
        Node pold=head;
        Node p2Head = pold!=null?pold.next:null;
        Node pnew=null;
        while(pold!=null) {
            Node nextNew=pold!=null?pold.next:null;;
            Node nextOld=pold.next!=null?pold.next.next:null;

            pnew=nextNew;
            pnew.next=nextOld!=null?nextOld.next:null;
            pold.next=nextOld;

            pold=pold.next;
        }

        return p2Head;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
