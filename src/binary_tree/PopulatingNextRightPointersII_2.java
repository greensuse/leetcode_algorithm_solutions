package binary_tree;

public class PopulatingNextRightPointersII_2 {
    public static void main(String[] args) {
        Node node1=new Node(); node1.val=1;
        Node node2=new Node(); node2.val=2;
        Node node3=new Node(); node3.val=3;
        Node node4=new Node(); node4.val=4;
        Node node5=new Node(); node5.val=5;
        Node node7=new Node(); node7.val=7;

        node1.left = node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.right=node7;

        Node result=connect(node1);
        System.out.println(result);
    }
    public static Node connect(Node root) {
        Node head=root;

        while(head!=null) {
            Node dummy=new Node();
            Node temp=dummy;

            while(head!=null) {
                if(head.left!=null) {
                    temp.next=head.left;
                    temp=temp.next;
                }
                if(head.right!=null) {
                    temp.next=head.right;
                    temp=temp.next;
                }
                head=head.next;
            }

            head=dummy.next;
        }

        return root;
    }

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }
}


