package binary_tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree_1 {

    public static void main(String[] args) {
        TreeNode node_1=new TreeNode(1);
        TreeNode node_2=new TreeNode(2);
        TreeNode node_3=new TreeNode(3);
        TreeNode node_4=new TreeNode(4);
        TreeNode node_5=new TreeNode(5);

        node_1.left=node_2;
        node_1.right=node_3;
        node_3.left=node_4;
        node_3.right=node_5;

        SerializeAndDeserializeBinaryTree_1 obj=new SerializeAndDeserializeBinaryTree_1();

        String serialized=obj.serialize(node_1);
        System.out.println(serialized);

        TreeNode root = obj.deserialize(serialized);
        System.out.println(root);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res=rserialize(root, "");
        return res;
    }

    private String rserialize(TreeNode root, String str) {
        if(root==null) {
            str+="null,";
        } else {
            str+=root.val+",";
            str=rserialize(root.left, str);
            str=rserialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null) return null;
        String[] vals=data.split(",");
        List<String> val_list= new LinkedList<String>(Arrays.asList(vals));
        return rdeserialize(val_list);
    }

    private TreeNode rdeserialize(List<String> val_list) {
        if(val_list.get(0).equals("null")) {
            val_list.remove(0);
            return null;
        }

        TreeNode root=new TreeNode(Integer.valueOf(val_list.get(0)));
        val_list.remove(0);
        root.left=rdeserialize(val_list);
        root.right=rdeserialize(val_list);

        return root;
    }
}
