package N_ary_Tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class NaryTreePreorderTraversal_2 {
    public List<Integer> preorder(Node root) {
        List<Integer> ans=new LinkedList<>();
        if(root==null) return ans;

        LinkedList<Node> stack=new LinkedList<>();
        stack.add(root);

        while(stack.size()>0) {
            Node node = stack.pollLast();
            ans.add(node.val);
            List<Node> children=node.children;
            Collections.reverse(children);
            for(Node item : children) {
                stack.add(item);
            }
        }

        return ans;
    }
}
