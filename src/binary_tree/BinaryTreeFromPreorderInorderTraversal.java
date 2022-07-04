package binary_tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreorderInorderTraversal {
        int index=0;
        Map<Integer, Integer> map= null;
        int[] preorder=null;
        int[] inorder = null;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
                map=new HashMap<>();
                for(int i=0; i<inorder.length; i++) {
                        map.put(inorder[i], i);
                }
                this.preorder=preorder;
                this.inorder=inorder;

                TreeNode node = dfs(0, inorder.length-1);
                return node;
        }

        private TreeNode dfs(int start, int end) {
                if(start>end) return null;

                int curVal = preorder[index++];
                int mid_index=map.get(curVal);

                TreeNode curNode= new TreeNode(curVal);

                curNode.left=dfs(start, mid_index-1);
                curNode.right=dfs(mid_index+1, end);

                return curNode;
        }
}
