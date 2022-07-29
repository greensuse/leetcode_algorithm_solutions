package graph;

public class ValidTree_5 {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;

        UnionFind2 unionFind2 = new UnionFind2(n);
        for(int[] edge: edges) {
            if(!unionFind2.union(edge[0], edge[1])) {
                return false;
            }
        }
        return true;
    }
}

class UnionFind2 {
    private int[] parent;
    private int[] size;

    public UnionFind2(int n) {
        parent=new int[n];
        size=new int[n];
        for(int i=0; i<n; i++) {
            parent[i]=i;
            size[i]=1;
        }
    }

    public int find(int A) {
        int root = A;
        while(parent[root]!=root) {
            root=parent[root];
        }

        while(parent[A]!=root) {
            int tmp=parent[A];
            parent[A]=root;
            A=tmp;
        }

        return root;
    }

    public boolean union(int A, int B) {
        int rootA=find(A);
        int rootB=find(B);
        if(rootA==rootB) {
            return false;
        }

        if(size[rootA]>size[rootB]) {
            parent[rootB]=rootA;
        } else if(size[rootA]<size[rootB]) {
            parent[rootA]=rootB;
        } else {
            parent[rootB]=rootA;
            size[rootA]+=1;
        }

        return true;
    }
}
