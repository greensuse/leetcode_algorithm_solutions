package list;

public class TwoLinkedListIntersection_2 {
    public static void main(String[] args) {
        ListNode node6= new ListNode(6);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node6.next = node3;
        node2.next = node4;
        node3.next = null;
        node4.next = node5;
        node5.next = null;

        ListNode result = getIntersectionNode(node6, node2);
        System.out.println(result);
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA=headA, pointerB=headB;
        while(pointerA!=pointerB) {
            pointerA=pointerA==null?headB:pointerA.next;
            pointerB=pointerB==null?headA:pointerB.next;
        }
        return pointerA;
    }
}
