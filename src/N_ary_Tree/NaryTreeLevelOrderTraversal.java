package N_ary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans=new LinkedList<>();
        if(root==null) return ans;

        List<Node> queue=new LinkedList<>();
        queue.add(root);

        while(queue.size()>0) {
            List<Integer> values=new ArrayList<>(queue.size());

            int node_num=queue.size();
            for(int i=0; i<node_num; i++) {
                Node node=queue.remove(0);
                values.add(node.val);

                List<Node> children=node.children;
                for(Node item : children) {
                    queue.add(item);
                }
            }

            ans.add(values);
        }

        return ans;
    }
}
