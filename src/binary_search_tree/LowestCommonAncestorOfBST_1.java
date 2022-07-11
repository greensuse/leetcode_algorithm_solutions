package binary_search_tree;

public class LowestCommonAncestorOfBST_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<root.val && q.val<root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if(p.val>root.val && q.val>root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
