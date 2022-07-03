package binary_tree;

import java.util.LinkedList;

public class PathSum_2 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;

        LinkedList<TreeNode> node_stack=new LinkedList<>();
        LinkedList<Integer> sum_stack=new LinkedList<>();
        node_stack.add(root);
        sum_stack.add(targetSum);

        TreeNode node=null;
        int current_sum=0;
        while(!node_stack.isEmpty()) {
            node=node_stack.pollLast();
            current_sum=sum_stack.pollLast()-node.val;
            if(node.left==null && node.right==null && current_sum==0) {
                return true;
            }

            if(node.left!=null) {
                node_stack.add(node.left);
                sum_stack.add(current_sum);
            }
            if(node.right!=null) {
                node_stack.add(node.right);
                sum_stack.add(current_sum);
            }
        }

        return false;
    }
}
