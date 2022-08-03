package graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths=new ArrayList<>();
        if(graph==null || graph.length==0) return paths;
        dfs(graph, 0, new ArrayList<>(), paths);
        return paths;
    }

    private void dfs(int[][] graph, int node, ArrayList<Integer> path, List<List<Integer>> paths) {
        path.add(node);
        if(node==graph.length-1) {
            paths.add(new ArrayList<Integer>(path));
            return;
        }

        for(int neighbor : graph[node]) {
            dfs(graph, neighbor, path, paths);
            path.remove(path.size()-1);
        }
    }
}
