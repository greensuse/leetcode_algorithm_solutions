package stack;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {
        Node node_1=new Node(1);
        Node node_2=new Node(2);
        Node node_3=new Node(3);
        Node node_4=new Node(4);

        node_1.neighbors.add(node_2);
        node_1.neighbors.add(node_4);
        node_2.neighbors.add(node_1);
        node_2.neighbors.add(node_3);
        node_4.neighbors.add(node_1);
        node_4.neighbors.add(node_3);
        node_3.neighbors.add(node_2);
        node_3.neighbors.add(node_4);

        Node clone = cloneGraph(node_1);
        System.out.println(clone);
    }

    static Map<Node, Node> visited=new HashMap<>();
    public static Node cloneGraph(Node node) {
        if(node==null) return node;
        if(visited.get(node)!=null) return visited.get(node);
        Node clone = new Node();
        clone.val=node.val;
        visited.put(node, clone);
        for(Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
