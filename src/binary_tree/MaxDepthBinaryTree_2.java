package binary_tree;

import java.util.LinkedList;

public class MaxDepthBinaryTree_2 {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;

        LinkedList<TreeNode> stack=new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();

        stack.add(root);
        depths.add(1);

        int depth=0, current_depth=0;
        while(!stack.isEmpty()) {
            current_depth=depths.pollLast();
            root=stack.pollLast();
            if(root!=null) {
                depth=Math.max(depth, current_depth);
                stack.push(root.left);
                stack.push(root.right);
                depths.push(current_depth+1);
                depths.push(current_depth+1);
            }

        }

        return depth;
    }
}
