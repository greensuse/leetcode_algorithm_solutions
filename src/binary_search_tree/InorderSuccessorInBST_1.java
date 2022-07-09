package binary_search_tree;

import java.util.LinkedList;
import java.util.List;

public class InorderSuccessorInBST_1 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> inorderNodes=new LinkedList<>();
        inorderTraversal(root, inorderNodes);
        int matchIndex=0;
        for(int i=0; i<inorderNodes.size(); i++) {
            if(inorderNodes.get(i).val==p.val) {
                matchIndex=i;
                break;
            }
        }

        if(matchIndex!=inorderNodes.size()-1) {
            return inorderNodes.get(matchIndex+1);
        }

        return null;
    }

    public void inorderTraversal(TreeNode root, List<TreeNode> inorderNodes) {
        if(root==null) return;
        inorderTraversal(root.left, inorderNodes);
        inorderNodes.add(root);
        inorderTraversal(root.right, inorderNodes);
    }
}
