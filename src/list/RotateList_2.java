package list;

public class RotateList_2 {
    public ListNode rotateRight(ListNode head, int k) {
        int size=0;
        ListNode p=head, prev=head;
        while(p!=null) {
            size++;
            prev=p;
            p=p.next;
        }


        if(size==0 || k%size==0) return head;

        prev.next=head;
        int start=size-k%size;

        p=head;
        prev=p;
        for(int i=0; i<start; i++) {
            prev=p;
            p=p.next;
        }

        prev.next=null;
        ListNode newHead=p;

        return newHead;
    }
}
