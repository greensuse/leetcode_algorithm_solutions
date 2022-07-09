package binary_search_tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator_1 {
    private List<Integer> nodeList=null;
    private int curIndex;
    public BinarySearchTreeIterator_1(TreeNode root) {
        nodeList=new ArrayList<>();
        doInorderTraverse(root, nodeList);
        curIndex=-1;
    }

    private void doInorderTraverse(TreeNode root, List<Integer>  nodeList) {
        if(root==null) return;
        doInorderTraverse(root.left, nodeList);
        nodeList.add(root.val);
        doInorderTraverse(root.right, nodeList);
    }

    public int next() {
        ++curIndex;
        return nodeList.get(curIndex);
    }

    public boolean hasNext() {
        return curIndex<(nodeList.size()-1);
    }
}
