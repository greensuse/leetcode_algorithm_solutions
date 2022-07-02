package binary_tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack=new LinkedList<>();
        LinkedList<Integer> res=new LinkedList<>();

        if(root==null) return res;

        stack.add(root);
        while(stack.size()>0) {
            root = stack.pollLast();
            res.add(root.val);
            if(root.right!=null) {
                stack.add(root.right);
            }
            if(root.left!=null) {
                stack.add(root.left);
            }
        }


        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
