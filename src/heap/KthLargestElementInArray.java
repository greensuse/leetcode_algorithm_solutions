package heap;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap=new PriorityQueue<>(2);
        for(int num : nums) {
            if(heap.size()<k) {
                heap.offer(num);
            } else {
                if(num<=heap.peek()) {
                    continue;
                } else {
                    heap.poll();
                    heap.offer(num);
                }
            }
        }

        return heap.peek();
    }
}
