package graph;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        if(points==null && points.length<=1) return 0;

        Queue<Edge> heap=new PriorityQueue<>((edge1, edge2)->edge1.cost-edge2.cost);

        for(int i=0; i<points.length-1; i++) {
            for(int j=i+1; j<points.length; j++) {
                int cost=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                heap.offer(new Edge(i, j, cost));
            }
        }

        int cost=0, edge_num=0;
        UnionFind unionFind=new UnionFind(points.length);

        while(heap.size()>0 && edge_num<=points.length-1) {
            Edge edge=heap.poll();
            if(!unionFind.connected(edge.point1, edge.point2)) {
                unionFind.union(edge.point1, edge.point2);
                cost+=edge.cost;
                edge_num++;
            }
        }

        return cost;
    }

    class Edge{
        int point1, point2, cost;

        Edge(int point1, int point2, int cost) {
            this.point1=point1;
            this.point2=point2;
            this.cost=cost;
        }
    }

    class UnionFind {
        int[] root;
        int[] rank;

        UnionFind(int size) {
            root=new int[size];
            rank=new int[size];
            for(int i=0; i<size; i++) {
                root[i]=i;
                rank[i]=1;
            }
        }

        public int find(int x) {
            if(x==root[x]) {
                return x;
            }

            return root[x]=find(root[x]);
        }

        public void union(int x, int y) {
            int rootX=find(x);
            int rootY=find(y);

            if(rootX!=rootY) {
                if(rank[rootX]>rank[rootY]) {
                    root[rootY]=rootX;
                } else if(rank[rootX]<rank[rootY]) {
                    root[rootX]=rootY;
                } else {
                    root[rootY]=rootX;
                    rank[rootX]+=1;
                }
            }
        }

        public boolean connected(int x, int y) {
            return find(x)==find(y);
        }
    }
}
