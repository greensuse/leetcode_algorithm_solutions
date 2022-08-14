package recursion_i;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode firstNode=head;
        ListNode secondNode=head.next;

        firstNode.next=swapPairs(secondNode.next);
        secondNode.next=firstNode;

        return secondNode;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
