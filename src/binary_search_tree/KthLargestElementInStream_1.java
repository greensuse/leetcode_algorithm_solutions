package binary_search_tree;

import java.util.PriorityQueue;

public class KthLargestElementInStream_1 {
    private static int K;
    private PriorityQueue<Integer> queue=null;

    public KthLargestElementInStream_1(int k, int[] nums) {
        this.K=k;
        queue = new PriorityQueue<>(k);

        for(int val : nums) {
            queue.offer(val);
        }

        while(queue.size()>k) {
            queue.poll();
        }
    }

    public int add(int val) {
        queue.offer(val);
        while(queue.size()>K) {
            queue.poll();
        }
        return queue.peek();
    }
}
