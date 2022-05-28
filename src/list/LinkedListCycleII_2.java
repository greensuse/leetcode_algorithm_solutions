package list;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycleII_2 {

    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        ListNode cycleStartNode = detectCycle(head);
        System.out.println(cycleStartNode.val);
    }
    public static ListNode detectCycle(ListNode head) {
        ListNode intersect = getIntersect(head);

        if(intersect==null) return null;

        while(head!=intersect) {
            head=head.next;
            intersect = intersect.next;
        }

        return head;
    }

    private static ListNode getIntersect(ListNode head) {
        if(head==null || head.next==null) return null;

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast) return slow;
        }

        return null;
    }

}


