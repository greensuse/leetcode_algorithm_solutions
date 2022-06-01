package list;

public class MergeTwoSortedList_2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode pre=dummy;
        while(list1!=null && list2!=null) {
            if(list1.val<=list2.val) {
                pre.next=list1;
                list1=list1.next;
            } else {
                pre.next=list2;
                list2=list2.next;
            }
            pre=pre.next;
        }

        pre.next=list1==null?list2:list1;

        return dummy.next;
    }
}
