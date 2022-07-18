package heap;

import java.util.PriorityQueue;

public class KthLargestElementInStream_2 {
    private final PriorityQueue<Integer> queue;
    private final int K;


    public KthLargestElementInStream_2(int k, int[] nums) {
        K=k;
        queue = new PriorityQueue<>(K);
        for (int i = 0; i < nums.length; ++i) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if(queue.size()<K) {
            queue.add(val);
        } else if(val>queue.peek()) {
            queue.poll();
            queue.add(val);
        }

        return queue.peek();
    }
}


