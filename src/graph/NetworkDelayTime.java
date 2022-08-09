package graph;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        //build the graph table/map
        Map<Integer, List<int[]>> graph=new HashMap<>();
        for(int[] time : times) {
            int src=time[0], tar=time[1], weight=time[2];
            if(!graph.containsKey(src)) {
                graph.put(src, new LinkedList<int[]>());
            }
            graph.get(src).add(new int[]{tar, weight});
        }

        Queue<int[]> minHeap=new PriorityQueue<>((x, y)->x[1]-y[1]);
        minHeap.add(new int[]{k, 0});

        Set<Integer> visited=new HashSet<>(n);

        int res=0;

        while(!minHeap.isEmpty()) {
            int[] top=minHeap.poll();
            int src=top[0], srcWeight=top[1];
            if(visited.contains(src)) continue;
            res=srcWeight;
            visited.add(src);
            if(!graph.containsKey(src)) continue;
            List<int[]> neighbors=graph.get(src);
            for(int[] edge: neighbors) {
                int tar=edge[0], tarWeight=edge[1];
                minHeap.add(new int[]{tar, srcWeight+tarWeight});

            }
        }

        return visited.size()==n?res:-1;
    }
}
