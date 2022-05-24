package list;

public class LinkedListCycle_1 {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head, fast=head;
        if(head==null || head.next==null) return false;

        while(fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;

            if(fast==null) return false;

            if(slow==fast) return true;
        }

        return false;
    }
    
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
}
