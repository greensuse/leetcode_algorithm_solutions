package graph;

public class NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        UnionFind3 unionFind=new UnionFind3(n);
        for(int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }

        return unionFind.getCount();
    }
}


class UnionFind3 {
    private int[] parent;
    private int[] size;
    private int count;

    public UnionFind3(int n) {
        parent=new int[n];
        size=new int[n];
        for(int i=0; i<n; i++) {
            parent[i]=i;
            size[i]=1;
        }
        count=n;
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

        count--;

        return true;
    }

    public int getCount() {return count;}
}