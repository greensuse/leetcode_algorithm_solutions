package binary_search;

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int closest_val=0;
        double min_diff=Double.MAX_VALUE;

        while(root!=null) {
            if(Math.abs(root.val-target)<min_diff) {
                min_diff=Math.abs(root.val-target);
                closest_val=root.val;
            }
            if(target>root.val) {
                root=root.right;
            } else {
                root=root.left;
            }
        }

        return closest_val;
    }
}

class TreeNode {
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
