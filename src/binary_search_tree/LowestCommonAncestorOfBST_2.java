package binary_search_tree;

public class LowestCommonAncestorOfBST_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node=root;
        while(node!=null) {
            if(p.val<node.val && q.val<node.val) {
                node = node.left;
            } else if(p.val>node.val && q.val>node.val) {
                node = node.right;
            } else {
                return node;
            }
        }

        return null;
    }
}
