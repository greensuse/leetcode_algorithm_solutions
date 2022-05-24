package list;

public class DesignLinkedList_1 {

    public static void main(String[] args) {
        DesignLinkedList_1 myLinkedList  = new DesignLinkedList_1();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        System.out.println(myLinkedList.get(4));
        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5, 0);
        myLinkedList.addAtHead(6);
    }

    Node head = null;

    public DesignLinkedList_1() {

    }

    public int get(int index) {
        if (head==null) return -1;
        int curIndex=0;
        Node curNode = head;
        while(curNode!=null) {
            if(index==curIndex) {
                return curNode.val;
            } else {
                curNode=curNode.next;
                curIndex++;
            }
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node newNode= new Node();
        newNode.val=val;
        newNode.next=head;
        head=newNode;
    }

    public void addAtTail(int val) {
        Node newNode = new Node();
        newNode.val=val;

        if(head==null) {
            head=newNode;
            return;
        }

        Node curNode = head;
        while(curNode.next!=null) {
            curNode=curNode.next;
        }

        curNode.next=newNode;
    }

    public void addAtIndex(int index, int val) {
        Node newNode= new Node();
        newNode.val=val;

        if(index==0) {
            newNode.next=head;
            head=newNode;
            return;
        }

        int curIndex=1;
        Node curNode = head;
        while(curNode!=null) {
            if(index==curIndex) {
                newNode.next=curNode.next;
                curNode.next=newNode;
                break;
            } else {
                curNode=curNode.next;
                curIndex++;
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (head==null) return;

        if(index==0) {
            head=head.next;
            return;
        }

        int curIndex=1;
        Node preNode=head;
        Node curNode = head.next;
        while(curNode!=null) {
            if(curIndex==index) {
                preNode.next=curNode.next;
                break;
            } else {
                preNode=curNode;
                curNode=curNode.next;
                curIndex++;
            }
        }
    }

    private class Node {
        int val;
        Node next;
    }
}
