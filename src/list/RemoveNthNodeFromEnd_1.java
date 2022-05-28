package list;

public class RemoveNthNodeFromEnd_1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode p = head;
        while(p!=null) {
            size++;
            p=p.next;
        }

        int removingIndex = size-n;

        ListNode sentinel = new ListNode();
        sentinel.next=head;
        ListNode pointer=sentinel;
        for(int i=0; i<removingIndex; i++) {
            pointer=pointer.next;
        }

        pointer.next=pointer.next.next;
        return sentinel.next;

    }
}
