package graph;

public class ValidTree_4 {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;

        UnionFind unionFind = new UnionFind(n);

        for(int[] edge: edges) {
            if(!unionFind.union(edge[0], edge[1])) {
                return false;
            }
        }

        return true;
    }
}

class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
        parent=new int[n];
        for(int i=0; i<n; i++) {
            parent[i]=i;
        }
    }

    public int find(int A) {
        while(parent[A]!=A) {
            A=parent[A];
        }
        return A;
    }

    public boolean union(int A, int B) {
        int rootA=find(A);
        int rootB=find(B);
        if(rootA==rootB) {
            return false;
        }

        parent[rootA] = rootB;
        return true;
    }
}
