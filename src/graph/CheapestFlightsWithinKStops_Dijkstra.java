package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops_Dijkstra {
    public static void main(String[] args) {
        int n=4;
        int[][] flights={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0;
        int dst=3;
        int k=2;
        int res=new CheapestFlightsWithinKStops_Dijkstra().findCheapestPrice(n, flights, src, dst, k);
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //Build the adjacency matrix
        int[][] adjMatrix=new int[n][n];
        for(int[] flight : flights) {
            adjMatrix[flight[0]][flight[1]]=flight[2];
        }

        //shortest distance array
        int[] distances=new int[n];
        
        //shortest steps array
        int[] currentStops=new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(currentStops, Integer.MIN_VALUE);
        distances[src]=0;
        currentStops[src]=0;

        //The priority queue would contain (node, cost, stops)
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[1]-b[1]);
        minHeap.offer(new int[]{src,0,0});

        while(!minHeap.isEmpty()) {
            int[] info=minHeap.poll();
            int node=info[0], cost=info[1], stops=info[2];

            //If destination is reached, return the cost to get there
            if(node==dst) return cost;

            //if there are no more steps left, continue
            if(stops==K+1) continue;

            //Examine and relax all neighboring edges if possible
            for(int nei=0; nei<n; nei++) {
                if(adjMatrix[node][nei]>0) {
                    int dU=cost;
                    int wUV=adjMatrix[node][nei];
                    if(dU+wUV<distances[nei]) {
                        distances[nei]=dU+wUV;
                        minHeap.offer(new int[] {nei, dU+wUV, stops+1});
                        currentStops[nei]=stops;
                    } else if(stops<currentStops[nei]) {
                        minHeap.offer(new int[] {nei, dU+wUV, stops+1});
                    }
                }
            }
        }

        return distances[dst]==Integer.MAX_VALUE?-1:distances[dst];
    }
}
