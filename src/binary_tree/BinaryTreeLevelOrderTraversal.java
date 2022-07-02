package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        int level=0;

        while(!queue.isEmpty()) {
            res.add(new ArrayList<Integer>());

            int length=queue.size();

            for(int i=0; i<length; i++) {
                TreeNode node = queue.poll();
                res.get(level).add(node.val);

                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
            }

            level++;
        }

        return res;
    }
}
