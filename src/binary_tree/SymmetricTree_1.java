package binary_tree;

public class SymmetricTree_1 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;

        return (root1.val==root2.val)
                && isSymmetric(root1.right, root2.left)
                && isSymmetric(root1.left, root2.right);
    }
}
