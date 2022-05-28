package list;

public class TwoLinkedListIntersection_1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA=headA, pointerB=headB;
        while(pointerA!=pointerB) {
            if(pointerA==null) {
                pointerA=headB;
            } else {
                pointerA=pointerA.next;
            }

            if(pointerB==null) {
                pointerB=headA;
            } else {
                pointerB=pointerB.next;
            }

            if(pointerA==null && pointerB==null) {
                //no intersection
                return null;
            } else if(pointerA==pointerB) {
                //intersection
                return pointerA;
            }
        }
        return pointerA;
    }
}
