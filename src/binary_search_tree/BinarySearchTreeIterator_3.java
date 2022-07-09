package binary_search_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTreeIterator_3 {
    Stack<TreeNode> stack=new Stack<>();

    public BinarySearchTreeIterator_3(TreeNode root) {
        doPartialTraverse(root);
    }

    private void doPartialTraverse(TreeNode root) {
        while(root!=null) {
            stack.push(root);
            root=root.left;
        }
    }

    public int next() {
        TreeNode node=stack.pop();
        doPartialTraverse(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.empty();
    }
}
