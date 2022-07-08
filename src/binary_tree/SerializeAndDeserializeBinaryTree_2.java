package binary_tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree_2 {

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

        SerializeAndDeserializeBinaryTree_2 obj=new SerializeAndDeserializeBinaryTree_2();

        String serialized=obj.serialize(node_1);
        System.out.println(serialized);

        TreeNode root = obj.deserialize(serialized);
        System.out.println(root);
    }

    final String X="X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return X;

        String left=serialize(root.left);
        String right=serialize(root.right);

        return new StringBuilder(String.valueOf(root.val)).append(",").append(left).append(",").append(right).toString();
    }

    String[] vals= null;
    int index=0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null) return null;
        vals=data.split(",");
        TreeNode node=rdeserialize();
        return node;
    }

    private TreeNode rdeserialize() {
        if(vals[index].equals("X")) {
            index++;
            return null;
        }

        TreeNode root=new TreeNode(Integer.valueOf(vals[index++]));
        root.left=rdeserialize();
        root.right=rdeserialize();

        return root;
    }
}
