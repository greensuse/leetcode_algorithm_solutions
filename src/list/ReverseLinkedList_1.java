package list;

public class ReverseLinkedList_1 {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode p = head;
        while(p!=null && p.next!=null) {
            ListNode target=p.next;
            p.next=p.next.next;
            target.next=dummy.next;
            dummy.next=target;
        }

        return dummy.next;
    }
}
