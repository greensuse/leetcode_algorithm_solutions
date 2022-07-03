package binary_tree;

public class CountUnivalueSubtrees_2 {
    int count=0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null) return 0;
        isUnival(root, 0);
        return count;
    }

    private boolean isUnival(TreeNode node, int val) {
        if(node==null) {
            return true;
        }


        if(!isUnival(node.left, node.val) | !isUnival(node.right, node.val)) {
            return false;
        }

        count++;

        return node.val==val;

    }
}
