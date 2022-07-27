package graph;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces_1 {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        PathCompressionOptimization disjointSet = new PathCompressionOptimization(n);
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(isConnected[i][j]==1) {
                    disjointSet.union(i, j);
                }
            }
        }

        Set<Integer> rootSet=new HashSet<>();
        for(int i=0; i<n; i++) {
            rootSet.add(disjointSet.find(i));
        }

        return rootSet.size();
    }
}

