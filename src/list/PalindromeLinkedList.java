package list;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {

        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null) {
            if(fast.next.next==null) break;

            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode firstHalfP=head, sencondHalfP=slow.next;

        if(sencondHalfP==null) return true;

        sencondHalfP=reverseList(sencondHalfP);

        while(firstHalfP!=null && sencondHalfP!=null) {
            if(firstHalfP.val==sencondHalfP.val) {
                firstHalfP=firstHalfP.next;
                sencondHalfP=sencondHalfP.next;
            } else {
                return false;
            }
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;

        ListNode p = head;
        while(head.next!=null) {
            ListNode temp = head.next;
            head.next=temp.next;
            temp.next=dummy.next;
            dummy.next=temp;
        }
        return dummy.next;
    }
}
