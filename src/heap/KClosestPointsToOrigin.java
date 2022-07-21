package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(k, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2) {
                return p2[0]*p2[0]+p2[1]*p2[1]-p1[0]*p1[0]-p1[1]*p1[1];
            }
        });

        for(int[] p : points) {
            if(queue.size()<k) {
                queue.offer(p);
            } else {
                int[] max_p=queue.peek();
                if(p[0]*p[0]+p[1]*p[1]-max_p[0]*max_p[0]-max_p[1]*max_p[1]<0) {
                    queue.poll();
                    queue.offer(p);
                }
            }
        }

        int[][] ans=new int[k][2];
        for(int i=k-1; i>=0; i--) {
            ans[i]=queue.poll();
        }

        return ans;
    }
}
