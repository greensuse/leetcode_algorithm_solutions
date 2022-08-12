package graph;

import java.util.Arrays;

public class CheapestFlightsWithinKStops_Bellman_Ford_2 {
    public static void main(String[] args) {
        int n=4;
        int[][] flights={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0;
        int dst=3;
        int k=2;
        int res=new CheapestFlightsWithinKStops_Bellman_Ford_2().findCheapestPrice(n, flights, src, dst, k);
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src==dst) return 0;
        int[] previous=new int[n];
        int[] current=new int[n];
        Arrays.fill(previous, Integer.MAX_VALUE);
        Arrays.fill(current, Integer.MAX_VALUE);

        previous[src]=0;
        for(int i=1; i<k+2; i++) {
            current[src]=0;
            for(int[] flight : flights) {
                int previous_flight=flight[0], current_flight=flight[1], cost=flight[2];
                if(previous[previous_flight]<Integer.MAX_VALUE) {
                    current[current_flight]=Math.min(current[current_flight], previous[previous_flight]+cost);
                }
            }
            previous=current.clone();
        }

        return  current[dst]<Integer.MAX_VALUE?current[dst]:-1;
    }
}
