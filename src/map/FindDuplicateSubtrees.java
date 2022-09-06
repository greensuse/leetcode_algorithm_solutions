package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    Map<String, Integer> map=null;
    List<TreeNode> res=null;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map=new HashMap<>();
        res=new ArrayList<>();

        traverse(root);
        return res;

    }

    public String traverse(TreeNode root) {
        if(root==null) return "$";

        String val=root.val+","+traverse(root.left)+","+traverse(root.right);

        map.put(val, map.getOrDefault(val, 0)+1);

        if(map.get(val)==2) {
            res.add(root);
        }

        return val;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
