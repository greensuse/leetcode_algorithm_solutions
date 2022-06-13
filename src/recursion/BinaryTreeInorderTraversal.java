package recursion;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        doTraverse(root, res);
        return res;
    }

    private void doTraverse(TreeNode root, List<Integer> res) {
        if(root!=null) {
            doTraverse(root.left, res);
            res.add(root.val);
            doTraverse(root.right, res);
        }
    }

    private class TreeNode {
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
}
