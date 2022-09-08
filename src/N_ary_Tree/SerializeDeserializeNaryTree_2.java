package N_ary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeNaryTree_2 {
    public static void main(String[] args) {
        Node node_1=new Node(1, new LinkedList<>());
        Node node_2=new Node(2, new LinkedList<>());
        Node node_3=new Node(3, new LinkedList<>());
        Node node_4=new Node(4, new LinkedList<>());
        Node node_5=new Node(5, new LinkedList<>());
        Node node_6=new Node(6, new LinkedList<>());
        Node node_7=new Node(7, new LinkedList<>());
        Node node_8=new Node(8, new LinkedList<>());
        Node node_9=new Node(9, new LinkedList<>());
        Node node_10=new Node(10, new LinkedList<>());

        List<Node> node1_children=new ArrayList<Node>();
        node_1.children.add(node_2);
        node_1.children.add(node_3);
        node_1.children.add(node_4);
        node_1.children.add(node_5);


        List<Node> node3_children=new ArrayList<Node>();
        node_3.children.add(node_6);
        node_3.children.add(node_7);

        List<Node> node5_children=new ArrayList<Node>();
        node_5.children.add(node_9);
        node_5.children.add(node_10);

        List<Node> node4_children=new ArrayList<Node>();
        node_4.children.add(node_8);

        String res= new SerializeDeserializeNaryTree_2().serialize(node_1);
        System.out.println(res);
    }

    final String X="X";
    final String COMMA=",";

    // Encodes a tree to a single string.
    StringBuilder sb=new StringBuilder();
    public String serialize(Node root) {
        if(root==null) return X;
        encode(root);
        int size=sb.length();
        sb.deleteCharAt(size - 1);
        return sb.toString();
    }

    private void encode(Node root) {
        sb.append(root.val).append(COMMA);
        List<Node> children = root.children;
        for(Node child : children) {
            encode(child);
        }
        sb.append(X).append(COMMA);
    }

    // Decodes your encoded data to tree.
    String[] data_arr;
    int index=0;
    public Node deserialize(String data) {
        String[] data_arr=data.split(COMMA);
        return decode();
    }

    private Node decode() {
        String curItem=data_arr[index++];
        if(curItem.equals(X)) return null;
        List<Node> children = new LinkedList<>();
        while(index< data_arr.length) {
            Node child=decode();
            if(child!=null) {
                children.add(child);
            } else {
                break;
            }
        }
        Node root=new Node(Integer.parseInt(curItem), children);
        return root;
    }
}

