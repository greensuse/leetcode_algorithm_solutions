package binary_search_tree;

import java.util.LinkedList;
import java.util.List;

public class InorderSuccessorInBST_2 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur=root, pre=null;

        while(cur!=null) {
            if(p.val<cur.val) {
                pre=cur;
                cur=cur.left;
            } else {
                cur=cur.right;
            }
        }

        return pre;
    }

}
