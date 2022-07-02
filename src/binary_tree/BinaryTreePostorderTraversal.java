package binary_tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {

        LinkedList<Integer> res=new LinkedList<>();
        if(root==null) return res;

        LinkedList<TreeNode> stack=new LinkedList<>();
        stack.add(root);

        while(stack.size()>0) {
            TreeNode node = stack.pollLast();

            res.add(0, node.val);
            if(node.left!=null) {
                stack.add(node.left);
            }
            if(node.right!=null) {
                stack.add(node.right);
            }
        }

        return res;
    }
}
