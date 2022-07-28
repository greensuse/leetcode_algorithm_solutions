package graph;

import java.util.*;

public class ValidTree_2 {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        boolean result = new ValidTree_2().validTree(5, edges);
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


        Stack<Integer> stack=new Stack<>();
        stack.push(0);

        Set<Integer> seen = new HashSet<>();
        seen.add(0);

        while(stack.size() > 0) {
            int node = stack.pop();
            for(int neighbor : adjacencyList.get(node)) {
                if(seen.contains(neighbor)) {
                    return false;
                }
                stack.push(neighbor);
                seen.add(neighbor);

                //Remove the link that goes in the opposite direction
                adjacencyList.get(neighbor).remove(node);
            }
        }

        return seen.size()==n;
    }
}
