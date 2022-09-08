package N_ary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeNaryTree_1 {
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

        String res= new SerializeDeserializeNaryTree_1().serialize(node_1);
        System.out.println(res);
    }

    final String X="X";
    final String COMMA=",";

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root==null) return X;

        //BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            int size=queue.size();
            for(int i=0; i<size;i++) {
                Node cur = queue.poll();
                if(cur==null) {
                    sb.append(X).append(COMMA);
                    break;
                }
                for (Node child : cur.children) {
                    queue.add(child);
                }

                queue.add(null);
                sb.append(cur.val).append(COMMA);
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] data_arr=data.split(COMMA);
        if(data_arr[0].equals(X)) {
            return null;
        }
        Node root=new Node(Integer.parseInt(data_arr[0]));
        //BFS
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        int i=2;
        while(i<data_arr.length) {
            Node first=queue.poll();

            //add children and next level
            List<Node> children=new LinkedList<>();
            while(!data_arr[i].equals(X)) {
                Node child=new Node(Integer.parseInt(data_arr[i++]));
                children.add(child);
                queue.add(child);
            }
            i++;
            first.children=children;
        }
        return root;
    }
}

