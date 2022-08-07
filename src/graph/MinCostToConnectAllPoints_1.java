package graph;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectAllPoints_1 {
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int size = points.length;
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        boolean[] visited = new boolean[size];
        int result = 0;
        int count = size - 1;
        // Add all edges from points[0] vertexs
        int[] coordinate1 = points[0];
        for (int j = 1; j < size; j++) {
            // Calculate the distance between two coordinates.
            int[] coordinate2 = points[j];
            int cost = Math.abs(coordinate1[0] - coordinate2[0]) +
                    Math.abs(coordinate1[1] - coordinate2[1]);
            Edge edge = new Edge(0, j, cost);
            pq.add(edge);
        }
        visited[0] = true;

        while (!pq.isEmpty() && count > 0) {
            Edge edge = pq.poll();
            int point1 = edge.point1;
            int point2 = edge.point2;
            int cost = edge.cost;
            if (!visited[point2]) {
                result += cost;
                visited[point2] = true;
                for (int j = 0; j < size; j++) {
                    if (!visited[j]) {
                        int distance = Math.abs(points[point2][0] - points[j][0]) +
                                Math.abs(points[point2][1] - points[j][1]);
                        pq.add(new Edge(point2, j, distance));
                    }
                }
                count--;
            }
        }
        return result;
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
