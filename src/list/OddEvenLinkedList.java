package list;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode insertP=head;
        ListNode prev=insertP.next;
        ListNode oddNodeTarget=prev.next;

        while(oddNodeTarget!=null) {
            prev.next=oddNodeTarget.next;
            oddNodeTarget.next=insertP.next;
            insertP.next=oddNodeTarget;

            insertP=insertP.next;
            prev=prev.next;
            if(prev==null) break;
            oddNodeTarget=prev.next;
        }

        return head;
    }
}
