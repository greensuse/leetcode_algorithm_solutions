package graph;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectAllPoints_2 {
    public int minCostConnectPoints(int[][] points) {
        if(points==null && points.length<=1) return 0;

        int size=points.length;
        Queue<Edge> heap=new PriorityQueue<>((edge1, edge2)->edge1.cost-edge2.cost);
        boolean[] visited=new boolean[size];

        int result=0, edge_num=0;

        for(int i=1; i<size; i++) {
            int cost=Math.abs(points[0][0]-points[i][0])+Math.abs(points[0][1]-points[i][1]);
            heap.offer(new Edge(0, i, cost));
        }

        visited[0]=true;

        while(heap.size()>0 && edge_num<=size-1) {
            Edge edge=heap.poll();
            int index=edge.point2;
            if(visited[index]) continue;

            result+=edge.cost;
            edge_num++;
            visited[index]=true;

            for(int i=0; i<size; i++) {
                if(!visited[i]) {
                    int cost=Math.abs(points[index][0]-points[i][0])+Math.abs(points[index][1]-points[i][1]);
                    heap.offer(new Edge(index, i, cost));
                }

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
}
