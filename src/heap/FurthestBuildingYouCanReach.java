package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public static void main(String[] args) {
        int[] heights={4,2,7,6,9,14,12};
        int bricks=5;
        int ladders=1;
        int ans=new FurthestBuildingYouCanReach().furthestBuilding(heights, bricks, ladders);
        System.out.println(ans);
    }
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();

        int n=heights.length;
        for(int i=0; i<n-1; i++) {
            int height=heights[i+1]-heights[i];
            if(height>0) {
                queue.offer(height);

                if(queue.size()>ladders) {
                    height=queue.peek();
                    if(height<=bricks) {
                        bricks-=height;
                        queue.poll();
                    } else {
                        return i;
                    }
                }
            }
        }

        return n-1;
    }
}
