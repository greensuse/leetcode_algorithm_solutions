package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FindIfPathExist {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjacencyList=new ArrayList<>(n);
        for(int i=0; i<n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> stack=new ArrayDeque<>(n);
        stack.push(source);

        boolean[] seen=new boolean[n];

        while(stack.size()>0) {
            int node=stack.pop();
            if(node==destination) return true;

            if(seen[node]) continue;

            seen[node]=true;
            for(int neighbor : adjacencyList.get(node)) {
                stack.push(neighbor);
            }
        }

        return false;
    }
}
