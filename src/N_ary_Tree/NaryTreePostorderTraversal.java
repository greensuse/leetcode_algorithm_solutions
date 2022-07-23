package N_ary_Tree;

import java.util.LinkedList;
import java.util.List;

public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> ans=new LinkedList<>();
        if(root==null) return ans;

        LinkedList<Node> stack=new LinkedList<>();
        stack.add(root);

        while(stack.size()>0) {
            Node item = stack.pollLast();
            //ans.add(0, item.val);
            ans.addFirst(item.val);
            List<Node> children=item.children;
            for(Node node : children) {
                stack.add(node);
            }
        }

        return ans;
    }
}
