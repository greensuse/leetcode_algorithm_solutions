package list;

public class AddTwoNumbers_2 {
    public static void main(String[] args) {
        ListNode node1=new ListNode(5);
        ListNode node2=new ListNode(6);
        ListNode node3=new ListNode(4);

        node1.next=node2;
        node2.next=node3;
        node3.next=null;

        //ListNode node40=new ListNode(7);
        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(4);
        ListNode node6=new ListNode(3);
        //node40.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=null;

        ListNode result = addTwoNumbers(node1, node4);
        System.out.println("\n"+result.toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0),p1=l1, p2=l2;
        ListNode p=dummy;

        int carry=0;
        while(p1!=null || p2!=null) {

            int x1=p1!=null?p1.val:0;
            int x2=p2!=null?p2.val:0;

            int sum =x1+x2+carry;
            carry=sum/10;

            p.next=new ListNode(sum%10);
            p=p.next;

            if(p1!=null) p1=p1.next;
            if(p2!=null) p2=p2.next;
        }
        if(carry>0) {
            p.next=new ListNode(carry);
        }
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(this.val);
            ListNode nextOne=this.next;
            while(nextOne!=null) {
                sb.append(", ").append(nextOne.val);
                nextOne=nextOne.next;
            }
            return sb.toString();
        }
    }
}
