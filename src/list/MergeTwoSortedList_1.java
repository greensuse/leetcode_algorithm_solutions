package list;

public class MergeTwoSortedList_1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head=null, prev=null, curr=null;

        ListNode p1=list1, p2=list2;

        while(p1!=null || p2!=null) {
            if(p1==null) {
                curr=p2;
                p2=p2.next;
            } else if(p2==null) {
                curr=p1;
                p1=p1.next;
            } else if(p1.val>p2.val) {
                curr=p2;
                p2=p2.next;
            } else {
                curr=p1;
                p1=p1.next;
            }

            if(head==null) {
                head=curr;
                prev=curr;
            } else {
                prev.next=curr;
                prev=curr;
            }
        }
        return head;
    }
}
