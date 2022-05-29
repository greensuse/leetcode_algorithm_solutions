package list;

public class ReverseLinkedList_2 {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode currentHead = head;

        while(head.next!=null) {
            ListNode p = head.next;
            head.next=p.next;
            p.next=currentHead;
            currentHead=p;
        }

        return currentHead;
    }
}
