package binary_search_tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator_2 {
    private List<Integer>  nodeList=new ArrayList<>();
    private int curIndex=0;
    public BinarySearchTreeIterator_2(TreeNode root) {
        doInorderTraverse(root);
    }

    private void doInorderTraverse(TreeNode root) {
        if(root==null) return;
        doInorderTraverse(root.left);
        nodeList.add(root.val);
        doInorderTraverse(root.right);
    }

    public int next() {
        return nodeList.get(curIndex++);
    }

    public boolean hasNext() {
        return curIndex<nodeList.size();
    }
}
