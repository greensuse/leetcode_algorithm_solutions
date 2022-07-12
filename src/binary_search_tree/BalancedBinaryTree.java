package binary_search_tree;

public class BalancedBinaryTree {
    final int UNBALANCED=-1;
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return dfs(root)!=UNBALANCED;
    }

    private int dfs(TreeNode root) {
        if(root.left==null && root.right==null) return 1;

        int leftH=0;
        if(root.left!=null) {
            leftH=dfs(root.left);
        }

        if(leftH==UNBALANCED) return UNBALANCED;

        int rightH=0;
        if(root.right!=null) {
            rightH=dfs(root.right);
        }

        if(rightH==UNBALANCED) return UNBALANCED;

        if(Math.abs(leftH-rightH)<=1) return Math.max(leftH, rightH)+1;
        return UNBALANCED;
    }
}
