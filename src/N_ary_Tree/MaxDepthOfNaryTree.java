package N_ary_Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxDepthOfNaryTree {
    public int maxDepth(Node root) {
        if(root==null) {
            return 0;
        } else if(root.children.size()==0) {
            return 1;
        } else {
            List<Integer> depths=new ArrayList<>(root.children.size());
            for(Node item: root.children) {
                depths.add(maxDepth(item));
            }
            return 1+ Collections.max(depths);
        }
    }
}
