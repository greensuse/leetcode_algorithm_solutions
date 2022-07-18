package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1) return stones[0];

        PriorityQueue<Integer> queue=new PriorityQueue<>(Collections.reverseOrder());

        for(int val : stones) {
            queue.add(val);
        }

        while(queue.size()>=2) {
            int val1=queue.poll();
            int val2=queue.poll();
            if(val1!=val2) {
                queue.add(val1-val2);
            }

        }

        if(queue.size()==0) return 0;

        return queue.peek();
    }
}
