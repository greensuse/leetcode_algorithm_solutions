package binary_tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderPostOrder {
    int index;
    int[] inorder;
    int[] postorder;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=postorder.length;
        this.inorder=inorder;
        this.postorder=postorder;
        map=new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(inorder[i], i);
        }
        index=n-1;
        TreeNode root=dfs(0, n-1);
        return root;
    }

    private TreeNode dfs(int start, int end) {
        if(start>end) return null;

        int curVal=postorder[index--];
        int mid=map.get(curVal);

        TreeNode node = new TreeNode(curVal);
        node.right=dfs(mid+1, end);
        node.left=dfs(start, mid-1);
        return node;
    }
}
