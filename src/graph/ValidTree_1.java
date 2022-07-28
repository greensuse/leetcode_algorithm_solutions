package graph;

import java.util.*;

public class ValidTree_1 {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        boolean result = new ValidTree_1().validTree(5, edges);
        System.out.println(result);
    }
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjacencyList=new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1);
        Stack<Integer> stack=new Stack<>();
        stack.push(0);

        while(stack.size() > 0) {
            int node = stack.pop();
            for(int neighbor : adjacencyList.get(node)) {
                if(parent.get(node)==neighbor) {
                    continue;
                } else if(parent.containsKey(neighbor)) {
                    return false;
                }
                stack.push(neighbor);
                parent.put(neighbor, node);
            }
        }

        return parent.size()==n;
    }
}
