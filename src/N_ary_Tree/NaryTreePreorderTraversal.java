package N_ary_Tree;

import java.util.LinkedList;
import java.util.List;


public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> ans=new LinkedList<>();
        if(root==null) return ans;

        LinkedList<Node> stack=new LinkedList<>();
        stack.add(root);

        while(stack.size()>0) {
            Node node = stack.pollLast();
            ans.add(node.val);
            List<Node> children=node.children;
            for(int i=children.size()-1; i>=0; i--) {
                stack.add(children.get(i));
            }
        }

        return ans;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};