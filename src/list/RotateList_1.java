package list;

public class RotateList_1 {
    public ListNode rotateRight(ListNode head, int k) {
        int size=0;
        ListNode p=head;
        while(p!=null) {
            size++;
            p=p.next;
        }

        if(size==0 || k%size==0) return head;

        int start=size-k%size;

        p=head;
        ListNode prev=p;
        for(int i=0; i<start; i++) {
            prev=p;
            p=p.next;
        }

        prev.next=null;
        ListNode newHead=p;

        while(p.next!=null) {
            p=p.next;
        }

        p.next=head;

        return newHead;
    }
}
