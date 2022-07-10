package binary_search_tree;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;

        if(root.val==key) {
            //no children
            if(root.left==null && root.right==null) return null;
                //1 child
            else if(root.left!=null && root.right==null) return root.left;
            else if(root.left==null && root.right!=null) return root.right;

            //2 child
            TreeNode node=helper(root.right, root);
            root.val=node.val;
        } else if(key<root.val) {
            root.left=deleteNode(root.left, key);
        } else {
            root.right=deleteNode(root.right, key);
        }

        return root;
    }

    private TreeNode helper(TreeNode root, TreeNode parent) {
        TreeNode cur=root, pre=parent;
        while(cur.left!=null) {
            pre=cur;
            cur=cur.left;
        }
        deleteNode(pre, cur.val);
        return cur;
    }
}
