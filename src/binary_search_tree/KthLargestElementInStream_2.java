package binary_search_tree;

import java.util.PriorityQueue;

public class KthLargestElementInStream_2 {
    public static void main(String[] args) {
        KthLargestElementInStream_2 queue = new KthLargestElementInStream_2(3, new int[]{4,5,8,2});
        int res=queue.add(3);
        System.out.println(res);
        res=queue.add(5);
        System.out.println(res);
        res=queue.add(10);
        System.out.println(res);
        res=queue.add(9);
        System.out.println(res);
        res=queue.add(4);
        System.out.println(res);
    }
    private Node root;
    private int m_k=0;

    public KthLargestElementInStream_2(int k, int[] nums) {
        root=null;
        for (int i = 0; i < nums.length; ++i) {
            root = insertNode(root, nums[i]);
        }
        m_k=k;
    }

    public int add(int val) {
        root = insertNode(root, val);
        return searchKth(root, m_k);
    }
    private Node insertNode(Node root, int val) {
        if(root==null) return new Node(val, 1);

        if(val>root.val) {
            root.right=insertNode(root.right, val);
        } else {
            root.left=insertNode(root.left, val);
        }
        root.cnt++;
        return root;
    }

    private int searchKth(Node root, int k) {
        int m = root.right!=null?root.right.cnt:0;
        if(k==m+1) return root.val;
        if(k<=m) {
            return searchKth(root.right, k);
        } else {
            return searchKth(root.left, k-m-1);
        }
    }

}

class Node {
    Node left, right;
    int val, cnt;
    public Node(int val, int cnt) {
        left=null;
        right=null;
        this.val=val;
        this.cnt=cnt;
    }
}
