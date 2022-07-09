package binary_search_tree;

public class InsertIntoBinarySearchTree_1 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        TreeNode node=root, pre=null;
        while(node!=null) {
            pre=node;
            if(val<node.val) {
                node=node.left;
            } else {
                node=node.right;
            }
        }

        TreeNode newNode=new TreeNode(val);
        if(val<pre.val) {
            pre.left=newNode;
        } else {
            pre.right=newNode;
        }

        return root;
    }
}
