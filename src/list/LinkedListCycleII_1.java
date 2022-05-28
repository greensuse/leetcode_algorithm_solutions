package list;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycleII_1 {
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
        if(head==null || head.next==null) return null;

        ListNode slow=head;
        ListNode fast=head.next;

        boolean isCycle=false;
        while(slow!=fast) {
            if(slow==null || fast==null || fast.next==null) {
                isCycle=false;
                break;
            }

            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast) isCycle=true;
        }

        if(slow==fast) {
            isCycle=true;
        }

        if(isCycle) {
            Map<Object, Integer> travelCrossTimes = new HashMap<>();
            slow=head;
            while(travelCrossTimes.get(slow)==null || travelCrossTimes.get(slow)==1) {
                travelCrossTimes.put(slow, travelCrossTimes.getOrDefault(slow, 0)+1);
                slow=slow.next;
            }
            return slow;
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
