package list;

public class LinkedListCycle_2 {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;

        ListNode slow=head, fast=head.next;

        while(slow!=fast) {
            if(fast==null || fast.next==null) return false;

            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast) return true;
        }

        return true;
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
