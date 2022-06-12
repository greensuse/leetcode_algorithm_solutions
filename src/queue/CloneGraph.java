package queue;

import java.util.*;

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

    public static Node cloneGraph(Node node) {
        if(node==null) return node;

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> visited=new HashMap<>();
        queue.offer(node);

        visited.put(node, new Node(node.val));

        while(!queue.isEmpty()) {
            Node oldNode = queue.poll();
            for(Node neighbor : oldNode.neighbors) {
                if(visited.get(neighbor)==null) {
                    Node neighborClone = new Node(neighbor.val);
                    visited.put(neighbor, neighborClone);
                    queue.offer(neighbor);
                }

                visited.get(oldNode).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
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
