package graph;

import java.util.Arrays;

public class CheapestFlightsWithinKStops_Bellman_Ford {
    public static void main(String[] args) {
        int n=4;
        int[][] flights={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0;
        int dst=3;
        int k=2;
        int res=new CheapestFlightsWithinKStops_Bellman_Ford().findCheapestPrice(n, flights, src, dst, k);
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        // We use two arrays for storing distances and keep swapping
        // between them to save on the memory
        long[][] distances = new long[2][n];
        Arrays.fill(distances[0], Integer.MAX_VALUE);
        Arrays.fill(distances[1], Integer.MAX_VALUE);
        distances[0][src] = distances[1][src] = 0;

        // K + 1 iterations of Bellman Ford
        for (int iterations = 0; iterations < K + 1; iterations++) {

            // Iterate over all the edges
            for (int[] edge : flights) {

                int s = edge[0], d = edge[1], wUV = edge[2];

                // Current distance of node "s" from src
                long dU = distances[1 - iterations&1][s];

                // Current distance of node "d" from src
                // Note that this will port existing values as
                // well from the "previous" array if they didn't already exist
                long dV = distances[iterations&1][d];

                // Relax the edge if possible
                if (dU + wUV < dV) {
                    distances[iterations&1][d] = dU + wUV;
                }
            }
        }

        return distances[K&1][dst] < Integer.MAX_VALUE ? (int)distances[K&1][dst] : -1;
    }
}
