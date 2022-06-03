package list;

public class AddTwoNumbers_1 {
    public static void main(String[] args) {
        ListNode node1=new ListNode(5);
        ListNode node2=new ListNode(6);
        ListNode node3=new ListNode(4);

        node1.next=node2;
        node2.next=node3;
        node3.next=null;

        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(4);
        ListNode node6=new ListNode(3);
        node4.next=node5;
        node5.next=node6;
        node6.next=null;

        ListNode result = addTwoNumbers(node1, node4);
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode p=dummy;

        ListNode p1=l1, p2=l2;
        int val1=0, val2=0, carry=0;
        while(p1!=null || p2!=null) {
            if(p1!=null) {
                val1=p1.val;
                p1=p1.next;
            } else {
                val1=0;
            }
            if(p2!=null) {
                val2=p2.val;
                p2=p2.next;
            } else {
                val2=0;
            }

            int sum =(val1+val2+carry)%10;
            carry=(val1+val2+carry)/10;

            ListNode node=new ListNode(sum);
            p.next=node;
            p=node;
        }
        if(carry!=0) {
            ListNode node=new ListNode(carry);
            p.next=node;
        }
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
